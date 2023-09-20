import React, { useContext } from "react";
import Chat from "./Chat";
import { UsernameContext } from "../context/UsernameContext";

function Popup() {
  const username = useContext(UsernameContext);
  return (
    <>
      <p className="chat-app-title">Chat app</p>
      <Chat props={username} />
    </>
  );
}

export default Popup;
