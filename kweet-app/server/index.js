const express = require('express');
const app = express();
const PORT = 4000; //TODO create properties file to put these

const http = require('http').Server(app);
const cors = require('cors');


app.use(cors());


const io = require('socket.io')(http, {
    cors: {
        origin: "http://localhost:3000"
    },
    //cookie: true //check if the server will send a cookie upon handshake
});


let connectedUsers = [];

io.on('connection', async (socket) => {
        console.log("socket connected! ");

        socket.on('newUser', (data) => {
            connectedUsers.push(data);
            console.log("Connected users ", connectedUsers)
            io.emit("connected-users", connectedUsers);
          });

        socket.on('chat-message', (kweet) => {
            console.log('message: ' + kweet.message + ' send by ' + kweet.username);
            //publier sur kafka d'abord et broadcast à la réception du listener Kafka
            socket.broadcast.emit('new-message', kweet);
          });

          socket.on('disconnect', () => {
            connectedUsers = connectedUsers.filter(user => user.socketID !== socket.id);
            console.log('user disconnected', socket.id);
            console.log("Connected users are now ", connectedUsers)
          });

});


const path = require('path');
const { default: axios } = require('axios');
const { Server } = require('http');

app.get('/', (req, res) => {
 res.sendFile(path.join(__dirname, '../client/public/index.html'));
});

http.listen(PORT, () => {
    console.log(`Server listening on ${PORT}`);
  });