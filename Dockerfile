# Etapa 1: build com Maven
FROM maven:3.8.5-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: runtime
FROM eclipse-temurin:17-alpine

WORKDIR /app
VOLUME /tmp
COPY --from=build /app/target/*.jar app.jar
ENV PROFILE=dev
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT java -Dspring.profiles.active=$PROFILE -jar app.jar