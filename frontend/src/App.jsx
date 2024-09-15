import { BrowserRouter } from "react-router-dom";
import Sidebar from "./components/Sidebar";
import { Router } from "./Router";

function App() {
  const layout = () => {
    return (
      <div className="flex">
        <Sidebar />
        <Router />
      </div>
    );
  };

  return (
    <>
      <BrowserRouter>{layout()}</BrowserRouter>
    </>
  );
}

export default App;
