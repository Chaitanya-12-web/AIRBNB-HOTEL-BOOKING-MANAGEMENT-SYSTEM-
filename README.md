# 🏨 Airbnb-Like Hotel Booking Management System (Backend)

A scalable backend system built with **Java** and **Spring Boot** designed to handle complex room reservation workflows, secure role-based access control, and high-concurrency database transactions.

---

## 🚀 Key Technical Highlights (Interview Hotspots)

*   **Concurrency & Race Condition Control:** Implemented Database-level **Pessimistic Locking (`SELECT FOR UPDATE`)** using Spring Data JPA to completely prevent double-booking of rooms during simultaneous user requests.
*   **Transactional Workflow Design:** Managed multi-step booking operations (Room Reservation ➡️ Guest Details ➡️ Payment Simulation ➡️ Confirmation) using Spring's `@Transactional` to ensure strict data consistency and rollbacks on failure.
*   **Advanced Security Architecture:** Structured a stateless authentication layer using **Spring Security** and **JWT** (JSON Web Tokens) featuring dual-token rotating architecture (Short-lived Access Tokens + Secure Refresh Tokens).
*   **Dynamic Pricing Design Pattern:** Applied the **Decorator Design Pattern** cleanly to handle run-time dynamic pricing strategies (e.g., peak seasonal charges, cleaning fees, and custom discounts).

---

## 🏗️ System Architecture & Request Flow

```text
[ Client Request ] 
       │
       ▼
[ Spring Security / Filter Chain ] ──► (Validates JWT Access Token)
       │
       ▼
[ BookingController ] ──► (Validates Input DTOs & Request Parameters)
       │
       ▼
[ BookingServiceImpl ] ──► (Executes @Transactional Workflow)
       │
       ├──► 1. Acquires Pessimistic Write Lock on Room Entity (`SELECT FOR UPDATE`)
       ├──► 2. Validates Room Availability Dates
       ├──► 3. Processes Guest & Payment Simulation
       └──► 4. Commits Transaction & Releases Lock
       │
       ▼
[ PostgreSQL Database ]
```

---

## 💻 Tech Stack

*   **Language:** Java 17+
*   **Frameworks:** Spring Boot, Spring MVC, Spring Security, Spring Data JPA
*   **Database:** PostgreSQL
*   **Tools:** Maven, Git

---

## ⚙️ How to Run Locally

### Prerequisites
* Java 17 or higher
* PostgreSQL Database running locally
* Maven

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com
   ```
2. Configure your local PostgreSQL database credentials in `src/main/resources/application.properties`.
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

