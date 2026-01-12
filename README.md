
# SaaS-Task-Management-Platform for Remote team
### A Full-Stack Productivity & Goal-Tracking SaaS (Spring Boot + React)

CompleteFocus is a real-world inspired productivity and focus-tracking application designed to help individuals and teams **plan daily goals, manage tasks, measure productivity, and stay accountable**.

This project is built with a **clean backend architecture**, **database migrations**, and a **modern dashboard-style frontend**, focusing on how production-ready systems are actually designed - not just CRUD demos.

---

## What CompleteFocus Does

CompleteFocus allows users to:
- Register and log in using email
- Create daily goals with clear intent
- Break goals into actionable tasks
- Track time spent on tasks
- Mark goals and tasks as completed
- View daily & weekly productivity summaries
- Receive productivity updates via email
- Interact through a clean, futuristic dashboard UI

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Flyway (Database migrations)
- MySQL
- REST APIs

### Frontend
- React (Vite)
- Tailwind CSS
- Fetch API
- Component-based dashboard UI

### Tools
- IntelliJ IDEA (Backend)
- VS Code (Frontend)
- Postman
- Git & GitHub

---

## System Architecture

```

React Dashboard (Frontend)
|
|  REST APIs (JSON)
|
Spring Boot Backend
|
Service Layer (Business Logic)
|
Repository Layer (JPA)
|
MySQL Database (Flyway Managed)

```

The system follows **layered architecture** with strict separation of concerns:
- Controller → Service → Repository
- DTOs & Mappers isolate APIs from entities
- Flyway controls database evolution

---

## Implementation Overview

### Backend Design
- RESTful APIs using Spring Boot
- DTO + Mapper pattern for clean data flow
- Service layer contains all business logic
- Repository layer handles persistence via JPA
- Flyway used for schema versioning and consistency

### Authentication
- Simple email + password authentication
- Login validates credentials using email
- Frontend stores logged-in user context
- APIs operate on user-specific data

> Authentication is intentionally lightweight for clarity and learning.

### Database
- MySQL used as relational database
- Flyway manages schema migrations
- Existing schemas integrated using Flyway baseline
- Versioned SQL scripts ensure stability

---

## 📡 API Documentation

### Base URL
```

[http://localhost:8080](http://localhost:8080)

```

All APIs consume and return **JSON** unless stated otherwise.

---

### Authentication APIs

#### Register User
```

POST /api/auth/register

````

Request:
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "role": "EMPLOYEE",
  "password": "password123"
}
````

Response:

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "role": "EMPLOYEE",
  "createdAt": "2025-08-10T10:30:00"
}
```

---

#### Login User

```
POST /api/auth/login
```

Request:

```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

Response:

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "role": "EMPLOYEE",
  "createdAt": "2025-08-10T10:30:00"
}
```

---

### User APIs

#### Get User by ID

```
GET /api/users/{userId}
```

---

#### Get All Users

```
GET /api/users
```

---

### Goal APIs

#### Create Goal

```
POST /api/goals
```

Request:

```json
{
  "title": "Finish API Documentation",
  "description": "Complete backend API docs today",
  "date": "2025-08-10",
  "userId": 1
}
```

---

#### Get Goals by User

```
GET /api/goals/user/{userId}
```

---

#### Close Goal

```
PUT /api/goals/{goalId}/close
```

---

### Task APIs

#### Create Task

```
POST /api/tasks
```

Request:

```json
{
  "title": "Write README",
  "description": "Add implementation and API sections",
  "timeSpent": 45,
  "userId": 1,
  "goalId": 5
}
```

---

#### Get Tasks by User

```
GET /api/tasks/user/{userId}
```

---

#### Mark Task as Completed

```
PUT /api/tasks/{taskId}/complete
```

---

#### Delete Task

```
DELETE /api/tasks/{taskId}
```

---

### Report APIs

#### Daily Report

```
GET /api/reports/daily/{userId}?date=2025-08-10
```

Response:

```json
{
  "goalsSet": 3,
  "goalsCompleted": 2,
  "tasksDone": 5,
  "totalTimeSpent": 180
}
```

---

#### Weekly Report

```
GET /api/reports/weekly/{userId}
```

---

#### Team Report

```
GET /api/reports/team
```

---

### 📧 Email APIs

#### Send Email

```
POST /api/email/send
```

Parameters:

```
to=receiver@example.com
subject=Daily Productivity Report
body=You completed 5 tasks today. Great job!
```

Response:

```
Email sent successfully.
```

---

## Running the Project

### Backend

```bash
git clone https://github.com/your-username/CompleteFocus.git
cd CompleteFocus
mvn spring-boot:run
```

Runs on:

```
http://localhost:8080
```

---

### Frontend

```bash
cd completefocus-frontend
npm install
npm run dev
```

Runs on:

```
http://localhost:5173
```

---

## Testing

* APIs tested using Postman
* Frontend tested via dashboard UI
* Flyway ensures schema consistency

---

## Future Enhancements

* JWT-based authentication
* Role-based access control
* Advanced analytics & charts
* PDF report export
* Docker & cloud deployment (AWS)

---

## Author

**Gausul Wara**
MCA-2026 batch | Java Backend Developer
Focused on building scalable, production-grade backend systems.

---

## Final Note

CompleteFocus is not just a CRUD project - it demonstrates:

* Real backend architecture
* Database versioning
* API design discipline
* Frontend-backend integration
* SaaS-style thinking

This project is built to **learn how real systems are made**, not just to pass exams.

### Documentation complete. Thank you for your time.
