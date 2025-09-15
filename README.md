# ecommPlugBack

Overview

Mini E-Commerce Backend is a Java/Spring Boot application that provides RESTful APIs for managing a simplified e-commerce system. The backend handles Users, Products, and Orders, with CRUD operations and order status updates.

The project focuses on clean API design, database modeling, and layered architecture, providing a foundation that can be extended with features like authentication, order items, and payment processing.

----------------------------------------------------------------------------------------------

Tech Stack

Language: Java 17

Framework: Spring Boot 3.x (Spring Web, Spring Data JPA)

Database: MySQL

Build Tool: Maven or Gradle

Testing / API Demo: Postman, curl

Optional Libraries: Lombok

----------------------------------------------------------------------------------------------

Architecture

Layered Design: controller → service → repository → entity and other layers such as DTO, ENUMS

Principles: RESTful endpoints, clear separation of concerns, exception handling, validation where needed

Deployment: Local Spring Boot application; API-first design (no frontend)

----------------------------------------------------------------------------------------------

Sample cURL Commands
Update Order Status (Windows CMD)
curl -X POST http://localhost:8080/orders/106/status -H "Content-Type: application/json" -d "{\"status\":\"DELIVERED\"}"

Update Order Status (Linux/macOS)
curl -X POST http://localhost:8080/orders/106/status -H 'Content-Type: application/json' -d '{"status":"DELIVERED"}'

----------------------------------------------------------------------------------------------

Features

CRUD operations for Users, Products, Orders

Dedicated order status update endpoint

Clean REST API design

Database modeling with Spring Data JPA

Tested via Postman / curl

----------------------------------------------------------------------------------------------

Limitations & Future Improvements

No authentication or role-based access control

No OrderItem modeling or total/stock calculations

No pagination, filtering, or Swagger/OpenAPI documentation

Unit tests and integration tests can be added
