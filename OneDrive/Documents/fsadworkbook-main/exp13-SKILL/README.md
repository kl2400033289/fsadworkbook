# Skill 13 - Deployment of Full-Stack Application (Spring Boot + React)

Date of the Session: __/__/____
Time of the Session: ______ to ______

## Project Structure

- `frontend/` - React client (Vite)
- `backend/` - Spring Boot REST API + static hosting
- `deploy-to-spring-static.ps1` - Deployment preparation helper script

## Task Mapping

1. Generate React production build:
	- `cd frontend`
	- `npm install`
	- `npm run build`

2. Package Spring Boot backend JAR:
	- `cd backend`
	- `mvn clean package -DskipTests`

3. Configure environment variables in React build:
	- `frontend/.env.development`: `VITE_API_BASE_URL=http://localhost:8080`
	- `frontend/.env.production`: `VITE_API_BASE_URL=` (same-origin in Spring static deployment)

4. Run backend JAR and verify APIs:
	- `java -jar backend/target/exp13-skill-0.0.1-SNAPSHOT.jar`
	- Verify: `http://localhost:8080/students`

5. Deploy React build through Spring Boot static folder:
	- Build frontend (`npm run build`)
	- Copy `frontend/dist/*` to `backend/src/main/resources/static/`
	- Repackage and run backend JAR

6. Test deployed application:
	- Open `http://localhost:8080`
	- Perform add, update, delete operations and confirm frontend-backend integration.

## One-Command Preparation

From project root:

`powershell -ExecutionPolicy Bypass -File .\deploy-to-spring-static.ps1`

Note: if Maven is not available in terminal PATH, package the backend from STS using Maven Build goals:

`clean package -DskipTests`
