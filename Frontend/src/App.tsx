import './App.css'
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {StartPage} from "./pages/StartPage";

function App() {

  return (
    <div className="App">
      <BrowserRouter>
          <Routes>
              <Route path="/" element={<StartPage/>} />
          </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
