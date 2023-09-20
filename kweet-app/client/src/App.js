import "./App.css";
import Login from "./components/Login";
import { UsernameProvider } from "./context/UsernameContext";
import { Buffer } from "buffer";
import { StrictMode } from "react";
// To remove buffer undefined error with Webpack V5.0
window.Buffer = window.Buffer || Buffer;

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <StrictMode>
          <UsernameProvider>
            <Login />
          </UsernameProvider>
        </StrictMode>
      </header>
    </div>
  );
}

export default App;
