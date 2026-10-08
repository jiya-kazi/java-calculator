# 🧮 Beautiful Java Web Calculator

A modern, beautifully styled web-based calculator built using **Java (Spark Framework)** for the backend logic and custom **HTML5 / CSS3** for a slick, responsive visual user interface. The entire application is containerized with Docker, allowing it to run seamlessly on any machine without needing Java or Maven pre-installed.

---

## ✨ Features
*   **Modern UI:** A clean, vibrant card-based layout with smooth interactions.
*   **Core Math Operations:** Supports Addition, Subtraction, Multiplication, and Division.
*   **Error Prevention:** Built-in validation to gracefully handle inputs like division by zero.
*   **Dockerized:** Multi-stage Docker build utilizing `eclipse-temurin` to keep production images tiny and fast.

---

## 🚀 Quick Start (Run from Docker Hub)

You do not need to download the source code to run this app. You can pull and run the fully compiled production container image directly from Docker Hub:

```bash
# Pull and run the container in one command
docker run -p 8080:8080 jiyakazi/java-calculator:1.0
```

Once the container starts up, open your web browser and navigate to:
🔗 **[http://localhost:8080](http://localhost:8080)**

---

## 🛠️ Local Development & Building from Source

If you want to modify the application UI or backend logic locally, follow these steps:

### Prerequisites
*   [Docker Desktop](https://docker.com) installed and running.

### 1. Build the Docker Image
Navigate to the root directory containing the `Dockerfile` and build the container image:

```bash
docker build -t jiyakazi/java-calculator:1.0 .
```

### 2. Run Locally
Test your freshly built local image:

```bash
docker run -p 8080:8080 jiyakazi/java-calculator:1.0
```

---

## 📦 Project Structure
```text
java-calculator/
├── Calculator.java   # Core backend server & embedded HTML interface template
├── pom.xml           # Apache Maven dependencies management configuration
└── Dockerfile        # Blueprint for multi-stage Docker compilation & packaging
```

---

## 🔗 Project Links
*   **Docker Hub Repository:** [jiyakazi/java-calculator on Docker Hub](https://docker.com)
