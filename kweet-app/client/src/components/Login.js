import React, { useContext, useState } from "react";
import axios from "axios";
import Popup from "./Popup";
import { UsernameContext } from "../context/UsernameContext";
import { socket } from "../socket";
function Login() {

  const [showPopup, setShowPopup] = useState(false);
  const { username, setUsername } = useContext(UsernameContext);


  const handleSubmit = async (event) => {
    event.preventDefault();
    await axios
      .get("http://localhost:8080/username?username=" + username)
      .then((response) => {
        if (response.status === 200) {
          setShowPopup(true);
        }
      })
      .catch(function (error) {
        console.log(JSON.stringify(error));
      });
      socket.emit('newUser', { username, socketID: socket.id, isConnected: false });
  };


  return !showPopup ? (
    <form onSubmit={handleSubmit}>
      <label>
        Username:
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  ) : (
    <Popup></Popup>
  );
}

export default Login;
