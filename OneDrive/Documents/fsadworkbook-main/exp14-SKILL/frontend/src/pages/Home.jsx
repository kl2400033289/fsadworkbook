import NavBar from "../components/NavBar";
import { getStoredUser } from "../services/authStorage";

function Home() {
  const user = getStoredUser();

  return (
    <div className="page-shell">
      <NavBar />
      <section className="card content-card">
        <p className="eyebrow">Skill 14</p>
        <h1>Home</h1>
        <p>
          Welcome, <strong>{user?.username}</strong>. Your session is active because your login
          details are stored in localStorage.
        </p>
        <p>
          Use the navigation bar to open your Profile page or logout and clear the current session.
        </p>
      </section>
    </div>
  );
}

export default Home;
