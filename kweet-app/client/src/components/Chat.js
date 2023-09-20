import axios from "axios";
import React, { useCallback, useEffect, useRef, useState } from "react";
import Kweet from "./Kweet";
import { socket } from "../socket";
import Users from "./Users";

function Chat({ props }) {
  const { username } = props;
  const [lastTweets, setLastTweets] = useState([]);

  const [tweet, setTweet] = useState({
    timestamp: 0,
    username: "",
    message: "",
  });

  const currentTweet = useRef({
    timestamp: 0,
    username: "",
    message: "",
  });

  const [message, setMessage] = useState("");

  useEffect(() => {
    if (message.length !== 0) {
      socket.emit("chat-message", tweet);
    }
    socket.on("new-message", function (data) {
      console.log("New message", data);
      setLastTweets((prevMessages) => [...prevMessages, data]);
    });

    // return () => {
    //   socket.disconnect();
    // };
  }, []);

  async function getLastTweets() {
    try {
      const response = await axios.get("http://localhost:8080/lastKweets");
      //console.log("API call lasttweets => ", response?.data);
      setLastTweets(response?.data);
    } catch (err) {
      const errorMessage = "Error: " + err.message;
    }
  }


  //TODO:  convert to useCallback ?
  useEffect(() => {
    if (lastTweets.length === 0) getLastTweets();
  }, []);


  const handleSubmit = async (event) => {
    event.preventDefault();
    setMessage(tweet.message);
    setLastTweets((prev) => [...prev, tweet]);
    await axios
      .post("http://localhost:8080/sendKweet", tweet)
      .then((response) => {
        if (response.status === 200) {
          //console.log("Data was sent");
        }
      })
      .catch(function (error) {
        console.log(JSON.stringify(error));
      });
    //reset input
    setTweet({
      timestamp: 0,
      username: "",
      message: "",
    });
    socket.emit("chat-message", tweet);
  };

  const onChange = useCallback((e) => {
    setTweet({
      timestamp: Date.now(),
      username: username,
      message: e.target.value,
    });
  }, []);

  return (
    <>
      <Users></Users>
      <div className="last-tweets">
        <Kweet kweets={lastTweets} />
      </div>
      <div className="chat-container">
        <form onSubmit={handleSubmit} id="tweet-form">
          <label>
            <input
              id="tweet"
              placeholder="What's on you mind?"
              value={tweet.message}
              onChange={onChange}
              ref={currentTweet}
            />
          </label>
          <button id="submit-button" type="submit">Submit</button>
        </form>
        <div className="current-user"> Speaking as {username}</div>
      </div>
    </>
  );
}

export default Chat;
