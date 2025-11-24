# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -q -e -DskipTests package

# The fat jar will usually be in target/sentiment-api-0.0.1-SNAPSHOT.jar
RUN ls target

# ---- Runtime stage ----
# Distroless Java 21 (small, no shell, good for production)
FROM gcr.io/distroless/java21-debian12

WORKDIR /app

COPY --from=build /app/target/sentiment-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Distroless uses ENTRYPOINT as array form
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
