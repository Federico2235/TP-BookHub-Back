# TP-BookHub-Back

Backend REST API for BookHub, a library management application developed as part of the ENI training project.

## Description

BookHub Back provides the server-side API for managing books, users, reservations and borrows.  
The application exposes REST endpoints consumed by the BookHub frontend and includes authentication and role-based access control using JWT.

## Authors

- Federico
- Sarah
- Christophe

## Tech Stack

- Java 25
- Spring Boot
- Spring Web MVC
- Spring Security
- Spring Data JPA / Hibernate
- SQL Server
- Gradle
- Lombok
- JWT

## Main Features

- User authentication with JWT
- Public book catalog access
- Book management for librarians and administrators
- Reservation system
- Borrow management
- Return date update for borrowed books
- Role-based backend security

## Security

The API uses JWT authentication. After login, the client receives a token and must send it in protected requests using the following header:

Authorization: Bearer <token>

Security rules are configured in `SecurityConfig`. Public access is allowed for authentication, user registration and book consultation. Protected operations require authentication or specific roles such as `MEMBER`, `LIBRARIAN` or `ADMIN`.

Examples of protected actions:

- Creating, updating or deleting books requires `LIBRARIAN` or `ADMIN`
- Managing borrows requires `LIBRARIAN` or `ADMIN`
- Creating reservations requires an authenticated user
- User-related endpoints require authentication, except user creation

## Main Endpoints

### Authentication

POST /api/auth/login

Authenticates a user and returns a JWT token.

### Users

POST /api/users  
GET /api/users/{id}  
PATCH /api/users/{id}  
DELETE /api/users/{id}

### Books

GET /api/books  
GET /api/books/{id}  
POST /api/books  
PATCH /api/books/{id}  
DELETE /api/books/{id}

### Reservations

GET /api/reservations  
GET /api/reservations/{id}  
GET /api/reservations/user/{id}  
POST /api/reservations  
DELETE /api/reservations/{id}

### Borrows

GET /api/borrows  
GET /api/borrows/{id}  
GET /api/borrows/user/{id}  
GET /api/borrows/book/{id}  
POST /api/borrows  
DELETE /api/borrows/{id}  
PATCH /api/borrows/{id}/return-date

## Project Setup

### Clone the repository

git clone https://github.com/Federico2235/TP-BookHub-Back.git  
cd TP-BookHub-Back

### Configure the database

Configure the SQL Server connection in the application configuration file:

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=BOOKHUB  
spring.datasource.username=your_username  
spring.datasource.password=your_password

### Run the application

Using the Gradle wrapper:

./gradlew bootRun

On Windows:

gradlew.bat bootRun

## API Testing

The API can be tested with Postman.

For protected endpoints, include the JWT token:

Authorization: Bearer <token>

Expected behavior:

No token        -> 401 Unauthorized  
Invalid token   -> 401 Unauthorized  
Wrong role      -> 403 Forbidden  
Valid role      -> Request allowed

## Notes

Frontend guards improve user experience, but backend security is the real source of protection. Every sensitive action must be validated by the backend using authentication, roles and business rules.

## Possible Improvements

- Add global exception handling for cleaner error responses
- Return proper HTTP status codes for business errors (e.g. 409 Conflict)
- Add pagination for lists
- Add refresh token support

