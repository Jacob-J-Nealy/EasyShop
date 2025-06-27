# 🛍️ EasyShop E-Commerce API

An enterprise-level RESTful web application that enables users to browse products, manage profiles, and interact with a persistent shopping cart system. Built using Java, Spring Boot, and MySQL.

---

## 🧾 About the Project

**EasyShop** is a fully functional back-end for an e-commerce platform where users can register, log in, browse a dynamic product catalog, maintain shopping cart items, and manage profile details. This project simulates the server-side logic for an online store and applies key object-oriented design principles, layered architecture, and security via JWT authentication.

Originally, users could only view products. But as features expanded across four major phases, customers can now register securely, maintain profiles, add items to their cart, and modify their orders seamlessly—all while preserving data across sessions.

---

## 💡 Challenges & Reflections

Developing EasyShop was a true test of my ability to write scalable, maintainable code across multiple layers—especially under time pressure and changing requirements. I worked through:

- Customizing SQL queries with nullable filters
- Integrating full user authentication with token management
- Handling cart persistence at the DAO level
- Building DAO classes and controllers from scratch

Despite bugs and setbacks, I stayed the course. I leaned heavily on Object-Oriented Programming and REST principles, and I grew tremendously in the process. EasyShop reflects not just code, but **resilience and personal growth**.

---

## 📌 Class Diagram

*Add a class diagram image here if available.*

---
## 🧠 Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Security + JWT**
- **MySQL (via JDBC)**
- **Maven**
- **Postman** (for API testing)
- **Object-Oriented Programming**
- **DAO Design Pattern**

---

## 🛠️ Setup Instructions

### 📦 Prerequisites
- Java 17+
- MySQL 8.x+
- IntelliJ IDEA (or similar)
- Postman (optional for testing)

### ⚙️ Steps
1. Clone the repo:

```bash
git clone https://github.com/your-username/easyshop.git
cd easyshop
```
2. Set up your MySQL database and schema

3. Configure database access in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/easyshop_db
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword

4. Run the application:
./mvnw spring-boot:run

## 🔐 Authentication & Authorization
- Register: POST /register
- Login: POST /login
- All secured endpoints require a Bearer token in the header:
- ROLE_ADMIN is required for admin-only endpoints.

## Team Members

- **Jacob Nealy** - Solo Developer (Future DevOps Engineer)

## Thanks

Shout Out to my Potato Instructor Raymond Mourn for his french fry guidance
Shout Out to Potato Sensei AI for all the Tips and Advice
Shout Out to Walter Donnellan (My Tutor) for sacrificing his lunch breaks and extra time to tutor me
Shoutout Out to Tiffany Obi for being the realest Tutor out there! 

- A special thanks to all classmates for their encouragement.
- Adam Jessie for the Idea of diplaying Options in Capstone 1 (completely stole that idea this time around)
- #FullStackFryers
- #SigmaData
