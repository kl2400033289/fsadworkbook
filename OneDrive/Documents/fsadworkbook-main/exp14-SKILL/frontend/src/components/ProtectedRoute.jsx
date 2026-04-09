import { Navigate, Outlet } from "react-router-dom";
import { getStoredUser } from "../services/authStorage";

function ProtectedRoute() {
  const user = getStoredUser();

  if (!user?.username) {
    return <Navigate to="/login" replace />;
  }

  return <Outlet />;
}

export default ProtectedRoute;
