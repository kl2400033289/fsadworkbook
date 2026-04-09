import { useEffect, useState } from 'react'

const emptyForm = {
  name: '',
  email: '',
  course: '',
}

function AddStudent({ selectedStudent, onSave, onCancel }) {
  const [formData, setFormData] = useState(emptyForm)

  useEffect(() => {
    if (selectedStudent) {
      setFormData({
        name: selectedStudent.name ?? '',
        email: selectedStudent.email ?? '',
        course: selectedStudent.course ?? '',
      })
      return
    }

    setFormData(emptyForm)
  }, [selectedStudent])

  const handleChange = (event) => {
    const { name, value } = event.target
    setFormData((currentForm) => ({ ...currentForm, [name]: value }))
  }

  const handleSubmit = async (event) => {
    event.preventDefault()
    const savedSuccessfully = await onSave(formData)
    if (savedSuccessfully) {
      setFormData(emptyForm)
    }
  }

  return (
    <section className="panel">
      <div className="panel-head">
        <h2>{selectedStudent ? 'Update Student' : 'Add Student'}</h2>
        <p>{selectedStudent ? 'Edit the selected record and save changes.' : 'Enter a new student and submit the form.'}</p>
      </div>

      <form className="form-grid" onSubmit={handleSubmit}>
        <label>
          Name
          <input name="name" value={formData.name} onChange={handleChange} placeholder="Student name" required />
        </label>

        <label>
          Email
          <input name="email" type="email" value={formData.email} onChange={handleChange} placeholder="student@email.com" required />
        </label>

        <label>
          Course
          <input name="course" value={formData.course} onChange={handleChange} placeholder="Course name" required />
        </label>

        <div className="form-actions">
          <button type="submit" className="btn btn-primary">
            {selectedStudent ? 'Update Student' : 'Add Student'}
          </button>
          {selectedStudent && (
            <button type="button" className="btn btn-secondary" onClick={onCancel}>
              Cancel Edit
            </button>
          )}
        </div>
      </form>
    </section>
  )
}

export default AddStudent
