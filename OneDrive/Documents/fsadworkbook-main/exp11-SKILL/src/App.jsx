import { useState } from 'react'
import Dashboard from './components/Dashboard'
import LocalUserList from './components/LocalUserList'
import UserList from './components/UserList'
import FakePostList from './components/FakePostList'

function App() {
  const [activePage, setActivePage] = useState('home')

  const renderActivePage = () => {
    if (activePage === 'local-users') {
      return <LocalUserList />
    }

    if (activePage === 'users-api') {
      return <UserList />
    }

    if (activePage === 'fake-posts') {
      return <FakePostList />
    }

    return (
      <section className="welcome-card">
        <h2>React API Integration - Skill 11</h2>
        <p>
          Use the links above to open local JSON users, JSONPlaceholder users,
          and Fake API posts.
        </p>
      </section>
    )
  }

  return (
    <main className="app-shell">
      <h1>News Portal Dashboard</h1>
      <Dashboard activePage={activePage} onNavigate={setActivePage} />
      {renderActivePage()}
    </main>
  )
}

export default App
