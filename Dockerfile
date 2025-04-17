# Etapa 1: Compilar el proyecto con Maven
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests  # Genera el JAR en /app/target/

# Etapa 2: Crear la imagen final
FROM amazoncorretto:21.0.4-alpine3.18
WORKDIR /app
COPY target/demoDockerRender-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]