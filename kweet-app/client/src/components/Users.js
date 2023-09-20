import React, { useContext, useState } from "react";
import { UsernameContext } from "../context/UsernameContext";
import { socket } from "../socket";

function Users() {
  const connectedUser = useContext(UsernameContext);
  const [users, setUsers] = useState([]);

  socket.on("connected-users", (data) => {
    setUsers(
      data.map((user) => {
        if (user.username === connectedUser.username) {
          return { ...user, isConnected: true };
        }
        return user;
      })
    );
  });

  return (
    <>
      <div className="users-container">
        <div className="list-users">Connected Users</div>
        {users?.map((user) => (
          <p
            key={user.socketID}
            className={user.isConnected ? "connected" : ""}
          >
            {user.username}
          </p>
        ))}
      </div>
    </>
  );
}

export default Users;
