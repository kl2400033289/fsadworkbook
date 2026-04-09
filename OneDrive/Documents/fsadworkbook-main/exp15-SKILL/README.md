# SKILL 15 - JWT-Based Authentication & Role Authorization

## Project Structure
- backend/ -> Spring Boot JWT + RBAC backend

## Implemented Tasks
1. User entity with username, password, role
2. `/auth/login` endpoint to generate JWT token
3. Spring Security configuration with JWT filter
4. Secured endpoints:
   - `POST /admin/add`
   - `DELETE /admin/delete`
   - `GET /employee/profile`
5. Valid/invalid token testing instructions included below
6. Postman testing flow included below
7. Full backend project pushed in a single repository folder

## Default Users (Seeded)
- ADMIN
  - username: `admin`
  - password: `admin123`
- EMPLOYEE
  - username: `employee`
  - password: `emp123`

## Run in STS
1. Import as Maven project using `exp15-SKILL/backend`.
2. Run `com.klu.exp15skill.Exp15SkillApplication`.
3. Backend starts at `http://localhost:8080`.

## Postman Testing

### 1) Login and get token
- Method: `POST`
- URL: `http://localhost:8080/auth/login`
- Body (JSON):
```json
{
  "username": "admin",
  "password": "admin123"
}
```
- Response contains `token`

### 2) ADMIN endpoint (valid admin token)
- Method: `POST`
- URL: `http://localhost:8080/admin/add?name=John`
- Header:
  - `Authorization: Bearer <admin_token>`
- Expected: `200 OK`

### 3) ADMIN endpoint (employee token)
- Use employee token on `/admin/add`
- Expected: `403 Forbidden`

### 4) EMPLOYEE profile endpoint
- Method: `GET`
- URL: `http://localhost:8080/employee/profile`
- Header:
  - `Authorization: Bearer <token>`
- Expected:
  - admin token -> `200 OK`
  - employee token -> `200 OK`

### 5) Without token
- Call `/admin/add` or `/employee/profile` without `Authorization`
- Expected: `403 Forbidden` (access denied)

### 6) Invalid token
- Use malformed token in `Authorization`
- Expected: access denied for secured endpoints
