function StudentList({ students, onEdit, onDelete }) {
  return (
    <section className="panel">
      <div className="panel-head">
        <h2>Student List</h2>
        <p>Live data from the Spring Boot backend</p>
      </div>

      <div className="table-wrap">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Course</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {students.length === 0 ? (
              <tr>
                <td colSpan="5" className="empty-state">
                  No students found. Add one using the form.
                </td>
              </tr>
            ) : (
              students.map((student) => (
                <tr key={student.id}>
                  <td>{student.id}</td>
                  <td>{student.name}</td>
                  <td>{student.email}</td>
                  <td>{student.course}</td>
                  <td>
                    <div className="row-actions">
                      <button type="button" className="btn btn-secondary" onClick={() => onEdit(student)}>
                        Update
                      </button>
                      <button type="button" className="btn btn-danger" onClick={() => onDelete(student.id)}>
                        Delete
                      </button>
                    </div>
                  </td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>
    </section>
  )
}

export default StudentList
