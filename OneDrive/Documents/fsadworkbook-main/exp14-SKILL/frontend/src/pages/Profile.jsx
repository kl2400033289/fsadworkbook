import { useEffect, useState } from "react";
import NavBar from "../components/NavBar";
import api from "../services/api";
import { getStoredUser } from "../services/authStorage";

function Profile() {
  const sessionUser = getStoredUser();
  const [profile, setProfile] = useState(null);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchProfile = async () => {
      try {
        setLoading(true);
        setError("");
        const response = await api.get(`/auth/profile?username=${sessionUser.username}`);
        setProfile(response.data);
      } catch (err) {
        setError(err.response?.data?.message || "Unable to fetch profile.");
      } finally {
        setLoading(false);
      }
    };

    fetchProfile();
  }, [sessionUser.username]);

  return (
    <div className="page-shell">
      <NavBar />
      <section className="card content-card">
        <h1>User Profile</h1>
        {loading && <p>Loading profile...</p>}
        {error && <p className="error-text">{error}</p>}

        {profile && (
          <div className="profile-grid">
            <div>
              <span>ID</span>
              <p>{profile.id}</p>
            </div>
            <div>
              <span>Username</span>
              <p>{profile.username}</p>
            </div>
            <div>
              <span>Email</span>
              <p>{profile.email}</p>
            </div>
          </div>
        )}
      </section>
    </div>
  );
}

export default Profile;
