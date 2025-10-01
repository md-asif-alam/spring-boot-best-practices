# Basic Auth & JWT

A simple implementation of **Basic Authentication** and **JWT (JSON Web Token)** for securing APIs and web applications.  
This project demonstrates how to protect routes using **HTTP Basic Authentication** (username/password) and **JWT-based authentication** (token-based session management).

---

## 🔑 What is Basic Authentication?

Basic Authentication is an HTTP authentication scheme that encodes a username and password using Base64 and sends it in the `Authorization` header of each request.  
While simple, it’s not considered secure on its own—credentials can be easily decoded if not used over **HTTPS**.

---

## 🔒 What is JWT Authentication?

**JWT (JSON Web Token)** is a stateless authentication mechanism. After successful login, the server issues a signed token that the client must send in the `Authorization: Bearer <token>` header for subsequent requests.  
The server validates the token without storing session data, making it scalable and efficient.

**Advantages of JWT over Basic Auth:**
- No need to send username/password on every request.
- Tokens can include user roles/permissions (claims).
- Stateless (no server-side session storage needed).
- Can have expiration times for security.

---

## 🚀 Features

- Protects API endpoints using **Basic Auth**.
- Supports **JWT Authentication** with `Bearer` tokens.
- Middleware-style integration for web frameworks.
- Minimal, lightweight, and easy to use.
- Secure routes with either Basic Auth or JWT.

---

## ⚙️ Usage

### 🔹 Basic Authentication
Send credentials in the header:


### 🔹 JWT Authentication
1. Login with valid credentials to receive a JWT token.
2. Use the token in subsequent requests:


---

## 📌 When to Use What?

- **Basic Auth**: Simple cases, testing, or internal APIs.  
- **JWT**: Production-ready APIs, mobile apps, or when scaling stateless authentication.

---
