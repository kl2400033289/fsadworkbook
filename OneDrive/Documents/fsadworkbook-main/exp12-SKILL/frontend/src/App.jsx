import { useEffect, useState } from 'react'
import axios from 'axios'
import AddStudent from './components/AddStudent'
import StudentList from './components/StudentList'
import './index.css'

function App() {
  const [students, setStudents] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')
  const [selectedStudent, setSelectedStudent] = useState(null)

  const API_BASE_URL = 'http://localhost:8080/students'

  const fetchStudents = async () => {
    try {
      setLoading(true)
      setError('')
      const response = await axios.get(API_BASE_URL)
      setStudents(response.data)
    } catch (fetchError) {
      setError(fetchError.message || 'Unable to load students.')
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchStudents()
  }, [])

  const handleSaveStudent = async (studentData) => {
    try {
      if (selectedStudent) {
        await axios.put(`${API_BASE_URL}/${selectedStudent.id}`, studentData)
      } else {
        await axios.post(API_BASE_URL, studentData)
      }

      setSelectedStudent(null)
      await fetchStudents()
      return true
    } catch (saveError) {
      setError(saveError.message || 'Unable to save student.')
      return false
    }
  }

  const handleDeleteStudent = async (id) => {
    try {
      await axios.delete(`${API_BASE_URL}/${id}`)
      if (selectedStudent?.id === id) {
        setSelectedStudent(null)
      }
      await fetchStudents()
    } catch (deleteError) {
      setError(deleteError.message || 'Unable to delete student.')
    }
  }

  return (
    <main className="app-shell">
      <header className="hero">
        <p className="eyebrow">Skill 12</p>
        <h1>Full-Stack Student CRUD</h1>
        <p className="hero-copy">
          React frontend + Spring Boot backend with immediate add, update, and delete updates.
        </p>
      </header>

      <div className="grid-layout">
        <AddStudent
          selectedStudent={selectedStudent}
          onSave={handleSaveStudent}
          onCancel={() => setSelectedStudent(null)}
        />

        <section className="panel">
          <div className="panel-head panel-head-inline">
            <div>
              <h2>Backend Status</h2>
              <p>GET, POST, PUT, and DELETE are wired to ResponseEntity endpoints.</p>
            </div>
            <button type="button" className="btn btn-secondary" onClick={fetchStudents}>
              Refresh
            </button>
          </div>

          {loading && <p className="status">Loading students...</p>}
          {error && <p className="status error">{error}</p>}
        </section>
      </div>

      <StudentList students={students} onEdit={setSelectedStudent} onDelete={handleDeleteStudent} />
    </main>
  )
}

export default App
