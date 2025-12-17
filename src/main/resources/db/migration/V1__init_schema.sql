-- Drop existing tables if they exist (use carefully in production!)
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS goals;
DROP TABLE IF EXISTS users;

-- Users table
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role ENUM('EMPLOYEE', 'TEAM_LEAD') NOT NULL,
    created_at VARCHAR(50) NOT NULL
);

-- Goals table
CREATE TABLE goals (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    date DATE NOT NULL,
    status ENUM('OPEN', 'CLOSED') DEFAULT 'OPEN',
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_goal_user FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);

-- Tasks table
CREATE TABLE tasks (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    time_spent INT NOT NULL,
    created_at DATETIME NOT NULL,
    status ENUM('PENDING', 'COMPLETED') DEFAULT 'PENDING',
    user_id BIGINT NOT NULL,
    goal_id BIGINT NULL,
    CONSTRAINT fk_task_user FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_task_goal FOREIGN KEY (goal_id)
        REFERENCES goals(id)
        ON DELETE SET NULL
);

-- Sample seed data
INSERT INTO users (name, email, role, created_at) VALUES
('Alice', 'alice@example.com', 'EMPLOYEE', '2025-08-01'),
('Bob', 'bob@example.com', 'TEAM_LEAD', '2025-08-01');
