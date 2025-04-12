FROM maven:3.8.5-eclipse-temurin-17 AS build

RUN mkdir /opt/app

COPY . /opt/app

WORKDIR /opt/app

RUN mvn clean package

FROM eclipse-temurin:17-jdk-alpine

RUN mkdir /opt/app

COPY --from=build  /opt/app/target/app.jar /opt/app/app.jar

WORKDIR /opt/app

ENV PROFILE=prd

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]