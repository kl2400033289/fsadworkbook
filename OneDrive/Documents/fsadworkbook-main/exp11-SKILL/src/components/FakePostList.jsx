import { useEffect, useMemo, useState } from 'react'
import axios from 'axios'

function FakePostList() {
  const [posts, setPosts] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')
  const [selectedUserId, setSelectedUserId] = useState('all')

  const loadPosts = async () => {
    try {
      setLoading(true)
      setError('')

      const response = await axios.get('https://dummyjson.com/posts')
      setPosts(response.data.posts || [])
    } catch (err) {
      setError(err.message || 'Something went wrong while loading posts.')
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    loadPosts()
  }, [])

  const userIds = useMemo(() => {
    return [...new Set(posts.map((post) => String(post.userId)))].sort(
      (a, b) => Number(a) - Number(b),
    )
  }, [posts])

  const filteredPosts = useMemo(() => {
    if (selectedUserId === 'all') {
      return posts
    }

    return posts.filter((post) => String(post.userId) === selectedUserId)
  }, [posts, selectedUserId])

  return (
    <section className="card">
      <div className="card-header">
        <h2>Fake API Posts (DummyJSON)</h2>
        <button onClick={loadPosts} className="action-btn" type="button">
          Refresh
        </button>
      </div>

      <div className="filter-row">
        <label htmlFor="userFilter">Filter by User ID:</label>
        <select
          id="userFilter"
          value={selectedUserId}
          onChange={(event) => setSelectedUserId(event.target.value)}
        >
          <option value="all">All Users</option>
          {userIds.map((id) => (
            <option key={id} value={id}>
              User {id}
            </option>
          ))}
        </select>
      </div>

      {loading && <p className="status">Loading fake API posts...</p>}
      {error && <p className="status error">{error}</p>}

      {!loading && !error && (
        <ul className="item-list">
          {filteredPosts.map((post) => (
            <li key={post.id} className="item">
              <h3>{post.title}</h3>
              <p>{post.body}</p>
              <p className="muted">User ID: {post.userId}</p>
            </li>
          ))}
        </ul>
      )}
    </section>
  )
}

export default FakePostList
