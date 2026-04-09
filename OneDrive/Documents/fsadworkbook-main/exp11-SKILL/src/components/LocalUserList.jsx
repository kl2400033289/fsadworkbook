import { useEffect, useState } from 'react'

function LocalUserList() {
  const [users, setUsers] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    const loadUsers = async () => {
      try {
        setLoading(true)
        setError('')

        const response = await fetch('/users.json')
        if (!response.ok) {
          throw new Error('Failed to load local users.')
        }

        const data = await response.json()
        setUsers(data)
      } catch (err) {
        setError(err.message || 'Something went wrong while loading users.')
      } finally {
        setLoading(false)
      }
    }

    loadUsers()
  }, [])

  return (
    <section className="card">
      <h2>Local Users (public/users.json)</h2>
      {loading && <p className="status">Loading local users...</p>}
      {error && <p className="status error">{error}</p>}

      {!loading && !error && (
        <ul className="item-list">
          {users.map((user) => (
            <li key={user.id} className="item">
              <h3>{user.name}</h3>
              <p>Email: {user.email}</p>
              <p>Phone: {user.phone}</p>
            </li>
          ))}
        </ul>
      )}
    </section>
  )
}

export default LocalUserList
