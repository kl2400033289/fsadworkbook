# SKILL 14 - User Authentication & Session Management (React + Spring Boot)

## Structure
- frontend/ -> React application
- backend/ -> Spring Boot application

## Backend Features
- Register user: `POST /auth/register`
- Login user: `POST /auth/login`
- Fetch profile using stored username: `GET /auth/profile?username=<name>`

## Frontend Features
- Register page with form submission
- Login page with session stored in localStorage
- Protected Home and Profile pages
- Redirect to login when session is missing
- Logout clears session and redirects to login

## Run Backend
1. Open `backend` in STS as a Maven project.
2. Run `com.klu.exp14skill.Exp14SkillApplication`.
3. Backend runs on `http://localhost:8080`.

## Run Frontend
```bash
cd frontend
npm install
npm run dev
```

Frontend runs on Vite dev server and calls backend APIs at `http://localhost:8080`.
