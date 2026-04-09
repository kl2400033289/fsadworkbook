# SKILL 16 - Swagger/OpenAPI for Student CRUD

## Structure
- backend/ -> Spring Boot Student CRUD + Swagger docs

## Swagger URLs
- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## Documented Endpoints
- `POST /students` -> Add a new student
- `GET /students` -> Retrieve all students
- `GET /students/{id}` -> Retrieve a student by ID
- `PUT /students/{id}` -> Update a student
- `DELETE /students/{id}` -> Delete a student

## Model Schema
`Student` fields are documented in Swagger schema with examples and validation:
- `id`
- `name`
- `email`
- `course`

## Validation + Error Responses
- Validation errors return:
```json
{
  "message": "Validation failed",
  "errors": {
    "name": "Name is required"
  }
}
```
- Invalid ID example (`/students/999`) returns Not Found:
```json
{
  "message": "Student not found with id: 999"
}
```

## Run in STS
1. Import Maven project from `exp16-SKILL/backend`.
2. Run `com.klu.exp16skill.Exp16SkillApplication`.
3. Open Swagger UI URL and test all CRUD APIs from the browser.
