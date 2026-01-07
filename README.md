# 🏨 e‑Hotels — Hotel Booking & Management Platform

**e‑Hotels** is a full‑stack hotel booking and management web application that allows customers to search and reserve rooms while enabling hotel staff to manage hotels, rooms, customers, and bookings through a structured interface.

The project focuses on **relational data modeling**, **backend business logic**, and a **server‑rendered web UI** built on top of a robust PostgreSQL database.

---

## ✨ Key Features

### 👤 Customer Experience
- Search available rooms using multiple criteria:
  - Dates (check‑in / check‑out)
  - Room capacity
  - Hotel category (1–5 stars)
  - Hotel chain
  - Location / area
  - Price range
- View real‑time room availability
- Book rooms for specific dates
- View hotel and room details

### 🧑‍💼 Employee Experience
- Manage hotel chains, hotels, and rooms
- Register and manage customers and employees
- Convert bookings into active rentals at check‑in
- Create rentals directly for walk‑in customers
- View archived booking and rental history

### 🗄️ Data & Business Rules
- Strong relational integrity between hotel chains, hotels, and rooms
- Historical records preserved even after deletions
- Support for room attributes such as:
  - Capacity
  - Amenities
  - View type (sea / mountain)
  - Extendability
  - Maintenance issues

---

## 🛠 Tech Stack

- **Java**
- **Spring Boot**
- **Spring MVC**
- **PostgreSQL**
- **JPA / Hibernate**
- **HTML & CSS**
- **Thymeleaf**

---

## 🧱 Architecture Overview

- **Controller Layer**
  - Handles routing and request processing
- **Service Layer**
  - Encapsulates business logic
- **Repository Layer**
  - Data access via JPA repositories
- **Database Layer**
  - PostgreSQL with normalized relational schema
- **View Layer**
  - Server‑rendered HTML templates with Thymeleaf

---

## 🚀 Running the Application

### Prerequisites
- Java 17+
- PostgreSQL
- Maven

### Steps
```bash
# configure database credentials in application.properties
mvn spring-boot:run
```

Then open:
```
http://localhost:8080
```

---

## 🧠 What This Project Demonstrates

- Designing and implementing a **non‑trivial relational database**
- Enforcing **referential integrity and business constraints**
- Building a layered Spring Boot application
- Server‑side rendering with dynamic data
- Real‑world booking and rental workflows

---

## 🔮 Possible Improvements

- Authentication & role‑based access control
- REST API + SPA frontend (React / Angular)
- Online payment integration
- Pagination & advanced search filters
- Dockerized deployment

---

📌 *A complete backend‑heavy web application that mirrors real hotel reservation systems and enterprise data workflows.*
