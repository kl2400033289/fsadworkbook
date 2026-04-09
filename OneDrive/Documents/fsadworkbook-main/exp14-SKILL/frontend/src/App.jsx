import { Navigate, Route, Routes } from "react-router-dom";
import ProtectedRoute from "./components/ProtectedRoute";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Profile from "./pages/Profile";
import Register from "./pages/Register";
import { getStoredUser } from "./services/authStorage";

function App() {
  const sessionUser = getStoredUser();

  return (
    <Routes>
      <Route path="/register" element={<Register />} />
      <Route path="/login" element={<Login />} />

      <Route element={<ProtectedRoute />}>
        <Route path="/home" element={<Home />} />
        <Route path="/profile" element={<Profile />} />
      </Route>

      <Route
        path="*"
        element={<Navigate to={sessionUser?.username ? "/home" : "/login"} replace />}
      />
    </Routes>
  );
}

export default App;
