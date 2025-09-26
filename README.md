# Basic Auth

A simple implementation of **Basic Authentication** for securing APIs and web applications.  
This project demonstrates how to protect routes using HTTP Basic Authentication, where a client must provide a valid username and password with each request.

---

## 🔑 What is Basic Authentication?

Basic Authentication is an HTTP authentication scheme that encodes a username and password using Base64 and sends it in the `Authorization` header of each request.
While simple, it’s not considered secure on its own—credentials can be easily decoded if not used over **HTTPS**.

---

## 🚀 Features

- Protects API endpoints using Basic Auth.
- Middleware-style integration for web frameworks.
- Minimal, lightweight, and easy to use.
