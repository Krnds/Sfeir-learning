import React, { useEffect, useState } from "react";
import "animate.css";
import { socket } from "../socket";

function Kweet({ kweets }) {
  const [updatedTweets, setUpdatedTweets] = useState(kweets);

  function convertToDate(timestamp) {
    const dateObj = new Date(timestamp);
    return dateObj.toLocaleString();
  }

  useEffect(() => {
    socket.on("new-message", (kweet) => {
      setUpdatedTweets((prev) => [...prev, kweet]);
      kweets.push(kweet);
    });

    kweets.sort((a, b) => a.timestamp - b.timestamp);
    return () => {
      socket.off("new-message");
    };
  }, [socket, kweets]);


  kweets.sort((a, b) => a.timestamp - b.timestamp);

  return (
    <>
      <div className="last-tweet-container">
        <div className="last-tweet-header">Last Messages</div>
        {kweets?.map((e, i) => (
          <>
            <div className="animate__animated animate__fadeInLeft">
              <div className="tweet-title">
                Sent by:{" "}
                <span className="tweet-content" key={e?.id}>
                  {e?.username}
                </span>
                at{" "}
                <span className="tweet-content">
                  {convertToDate(e.timestamp)}
                </span>
              </div>
              <div className="tweet-title" key={`i${e.id}`}>
                <span className="tweet-content message">💬 {e?.message}</span>
              </div>
              <div className="space"></div>
            </div>
          </>
        ))}
      </div>
    </>
  );
}

export default Kweet;
