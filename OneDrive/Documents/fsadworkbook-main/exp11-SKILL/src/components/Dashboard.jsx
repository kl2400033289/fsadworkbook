function Dashboard({ activePage, onNavigate }) {
  const links = [
    { id: 'home', label: 'Home' },
    { id: 'local-users', label: 'Local Users' },
    { id: 'users-api', label: 'Users API' },
    { id: 'fake-posts', label: 'Fake API Posts' },
  ]

  return (
    <nav className="dashboard-nav" aria-label="Dashboard navigation">
      {links.map((link) => (
        <a
          key={link.id}
          href={`#${link.id}`}
          onClick={(event) => {
            event.preventDefault()
            onNavigate(link.id)
          }}
          className={activePage === link.id ? 'nav-link active' : 'nav-link'}
        >
          {link.label}
        </a>
      ))}
    </nav>
  )
}

export default Dashboard
