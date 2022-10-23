import './App.css'
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {StartPage} from "./pages/StartPage";
import {QueryClient, QueryClientProvider} from "react-query";
import {InputContextProvider} from "./components/InputContext";

function App() {
const queryClient = new QueryClient()
  return (
    <div className="App">
      <BrowserRouter>
          <QueryClientProvider client={queryClient}>
              <InputContextProvider>
                  <Routes>
                      <Route path="/" element={<StartPage/>} />
                  </Routes>
              </InputContextProvider>
          </QueryClientProvider>
      </BrowserRouter>
    </div>
  )
}

export default App
