CompleteFocus---Backend-Part
Task Tracking & Workflow Management System
PulseBoard is a modern task tracking and workflow management system designed to help individuals and teams organize tasks, set goals, and monitor progress in real time. It features a dynamic dashboard with a responsive UI, email notifications, and external API integration. Built with Spring Boot, MySQL, AWS on the backend and React + Tailwind CSS on the frontend, PulseBoard is secure, scalable, and user-friendly, making task management simple and efficient.

API Reference
Get all users
  GET /api/users
Get users by role
  GET /api/users/role/{role}
Goals
Create goal
  POST /api/goals
Get goals by user
  GET /api/goals/user/{userId}
Close goal
  PUT /api/goals/{goalId}/close
Tasks
Get tasks by user
  GET /api/tasks/user/{userId}
Mark task complete
  PUT /api/tasks/{taskId}/complete
Reports
Get daily report
  GET /api/reports/daily/{userId}?date=YYYY-MM-DD
Get weekly report
  GET /api/reports/weekly/{userId}
Get team report
  GET /api/reports/team
Email
Send report via email
 POST /api/email/send 
Request Params
to → recipient email

subject -> email subject

body -> email body
POST /api/email/send?to=gausul@focus.dev&subject=Daily Report&body=You completed 3 tasks today!
add(num1, num2)
Takes two numbers and returns the sum.

Deployment
To deploy this project run

  npm run deploy
Deployment
Prerequisites
Java 17+
Maven 3.9+
MySQL 8+
(Optional) AWS Account if you want to deploy on EC2 or integrate S3
Git installed
Local Setup
Clone the repository
git clone https://github.com/your-username/completefocus.git
cd completefocus


Thanks for reading, let’s build something great together!
