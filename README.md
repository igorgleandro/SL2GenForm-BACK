# SL2GenForm Backend

A Spring Boot backend application for managing insurance forms, insurers, and coverage codes.

## 📋 Overview

SL2GenForm is a REST API backend that handles user authentication, form management, and insurance-related data. Built with Spring Boot 3.4.1 and Java 21, it provides JWT-based authentication and a complete CRUD API for insurance forms.

## 🚀 Features

- **User Authentication**: JWT-based authentication with BCrypt password encryption
- **Form Management**: Create, read, update, and delete insurance forms
- **Insurer Database**: Access to insurer information including NAIC codes and websites
- **Coverage Codes**: Manage insurance coverage code mappings
- **Multi-region Deployment**: Configured for Railway deployment with EU region support

## 🛠️ Technologies

- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Security** with JWT authentication
- **Spring Data JPA** for database access
- **MySQL** database
- **Flyway** for database migrations
- **Lombok** for reducing boilerplate code
- **SpringDoc OpenAPI** for API documentation

## 📦 Installation

### Prerequisites

- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+

### Setup

1. Clone the repository
```bash
git clone <repository-url>
cd SL2GenForm-Back
```

2. Configure your database in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sl2genform
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Set JWT configuration:
```properties
jwt.secret=your-secret-key-here
jwt.expiration=86400000
```

4. Build the project:
```bash
mvn clean install
```

5. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 🔐 Authentication

The API uses JWT Bearer token authentication. 

### Login
```http
POST /api/v1/auth/login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "password123"
}
```

Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIs...",
  "type": "Bearer",
  "email": "user@example.com",
  "name": "John",
  "surname": "Doe",
  "user_id": 1,
  "role": "USER",
  "avatar": "avatar-url",
  "theme": "light"
}
```

### Using the Token
Include the token in subsequent requests:
```http
Authorization: Bearer <your-token-here>
```

## 📚 API Endpoints

### Users
- `GET /users` - Get all users (authenticated)
- `POST /users` - Register new user (public)
- `PATCH /users/{id}` - Update user (authenticated)
- `/users/{id}` - Delete user (authenticated)

### Forms
- `GET /myforms` - Get all forms (authenticated)
- `GET /myforms/{id}` - Get form by ID (authenticated)
- `POST /myforms` - Create new form (authenticated)
- `PATCH /myforms/{id}` - Update form (authenticated)
- `DELETE /myforms/{id}` - Delete form (authenticated)
- `GET /users/{userId}/myforms` - Get user's forms (authenticated)

### Insurers
- `GET /insurers` - Get all insurers (public)

### Coverage Codes
- `GET /covcode` - Get all coverage codes (public)

## 📖 API Documentation

Once the application is running, access the Swagger UI documentation at:
```
http://localhost:8080/swagger-ui/index.html
```

API documentation in JSON format:
```
http://localhost:8080/v3/api-docs
```

## 🗄️ Database Schema

### Users Table
- `user_id` (PK, Auto-increment)
- `name`, `surname`, `email`, `password`
- `role`, `avatar`, `theme`

### MyForms Table
- `id` (PK, Auto-increment)
- `user_id` (FK to Users)
- Agent information (name, number, agency)
- Insured information (name, risk description, coverage code)
- Up to 3 insurers with contact details

### Insurers Table
- `id` (PK)
- `insurer`, `naic`, `website`

### CovCodes Table
- `id` (PK)
- `code`, `name`

## 🚢 Deployment

The application is configured for Railway deployment with the following settings:

- **Builder**: RAILPACK
- **Runtime**: V2
- **Region**: europe-west4
- **Restart Policy**: ON_FAILURE (max 10 retries)

Environment variables needed for production:
```
SPRING_DATASOURCE_URL=<database-url>
SPRING_DATASOURCE_USERNAME=<db-username>
SPRING_DATASOURCE_PASSWORD=<db-password>
JWT_SECRET=<jwt-secret-key>
JWT_EXPIRATION=86400000
```

## 🔧 Development

### Running Tests
```bash
mvn test
```

### Database Migrations
Flyway migrations are located in `src/main/resources/db/migration/`

Run migrations manually:
```bash
mvn flyway:migrate
```

## 🌐 CORS Configuration

The application allows CORS requests from:
- `http://localhost:5173` (development)
- `https://sl2genform-app-production.up.railway.app` (production)

## 📝 License

This project is private and proprietary.

## 👥 Contact

For questions or support, please contact the development team.

---

Built with ☕ and Spring Boot