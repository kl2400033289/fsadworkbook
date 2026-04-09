import { Link, useNavigate } from "react-router-dom";
import { clearStoredUser, getStoredUser } from "../services/authStorage";

function NavBar() {
  const navigate = useNavigate();
  const user = getStoredUser();

  const handleLogout = () => {
    clearStoredUser();
    navigate("/login");
  };

  return (
    <nav className="nav-bar">
      <div className="brand">Skill 14 Auth</div>
      <div className="nav-links">
        <Link to="/home">Home</Link>
        <Link to="/profile">Profile</Link>
        <button type="button" className="btn-logout" onClick={handleLogout}>
          Logout
        </button>
      </div>
      <div className="nav-user">{user?.username}</div>
    </nav>
  );
}

export default NavBar;
