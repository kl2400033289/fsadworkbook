# Skill 12 - Full-Stack CRUD Application

Date of the Session: __/__/____
Time of the Session: ______ to ______

## Structure

- `frontend/` - React app created with Vite
- `backend/` - Spring Boot REST API using Spring Web, Spring Data JPA, and H2

## Frontend Dependencies

- `react`
- `react-dom`
- `axios`

## Backend Dependencies

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `h2`

## Run Instructions

### Backend

1. Open `backend/` in a terminal.
2. Run the Spring Boot app with Maven.
3. The API will be available at `http://localhost:8080/students`.

### Frontend

1. Open `frontend/` in a terminal.
2. Run `npm install` if needed.
3. Run `npm run dev`.
4. The UI will connect to the backend API automatically.

## API Endpoints

- `POST /students`
- `GET /students`
- `PUT /students/{id}`
- `DELETE /students/{id}`
