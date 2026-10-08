# Step 1: Build the Java application using Maven
FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY Calculator.java .
RUN mknod /dev/urandom c 1 9 || true
RUN mvn clean package

# Step 2: Run the compiled application using an active, supported Java runtime
FROM eclipse-temurin:11-jre-alpine
WORKDIR /app
COPY --from=build /app/target/java-calculator-1.0.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
