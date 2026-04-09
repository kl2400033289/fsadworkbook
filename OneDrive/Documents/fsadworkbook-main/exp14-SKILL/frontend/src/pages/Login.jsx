import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../services/api";
import { setStoredUser } from "../services/authStorage";

function Login() {
  const navigate = useNavigate();
  const [form, setForm] = useState({ username: "", password: "" });
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    setError("");

    try {
      setLoading(true);
      const response = await api.post("/auth/login", form);
      setStoredUser({
        userId: response.data.userId,
        username: response.data.username,
      });
      navigate("/home");
    } catch (err) {
      setError(err.response?.data?.message || "Login failed.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="auth-shell">
      <section className="card auth-card">
        <h1>Login</h1>
        <p>Sign in to open Home and Profile pages.</p>

        <form className="form-grid" onSubmit={handleSubmit}>
          <label>
            Username
            <input
              type="text"
              name="username"
              value={form.username}
              onChange={handleChange}
              required
              placeholder="Enter username"
            />
          </label>

          <label>
            Password
            <input
              type="password"
              name="password"
              value={form.password}
              onChange={handleChange}
              required
              placeholder="Enter password"
            />
          </label>

          <button type="submit" className="btn-primary" disabled={loading}>
            {loading ? "Signing in..." : "Login"}
          </button>
        </form>

        {error && <p className="error-text">{error}</p>}

        <p className="switch-link">
          New user? <Link to="/register">Create account</Link>
        </p>
      </section>
    </div>
  );
}

export default Login;
