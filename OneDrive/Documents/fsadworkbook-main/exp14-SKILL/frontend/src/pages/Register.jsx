import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../services/api";

function Register() {
  const navigate = useNavigate();
  const [form, setForm] = useState({ username: "", email: "", password: "" });
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
      await api.post("/auth/register", form);
      navigate("/login");
    } catch (err) {
      setError(err.response?.data?.message || "Registration failed.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="auth-shell">
      <section className="card auth-card">
        <h1>Create Account</h1>
        <p>Register a new user, then continue with login.</p>

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
            Email
            <input
              type="email"
              name="email"
              value={form.email}
              onChange={handleChange}
              required
              placeholder="you@example.com"
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
            {loading ? "Registering..." : "Register"}
          </button>
        </form>

        {error && <p className="error-text">{error}</p>}

        <p className="switch-link">
          Already have an account? <Link to="/login">Login</Link>
        </p>
      </section>
    </div>
  );
}

export default Register;
