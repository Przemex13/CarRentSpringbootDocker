FROM maven:3.9.5-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

#FROM openjdk:17-jdk-slim

#VOLUME /tmp

#ARG JAR_FILE=target/blog-0.0.1-SNAPSHOT.jar

#COPY --from=build /app/${JAR_FILE} app.jar

#ENTRYPOINT ["java", "-jar","/app.jar"]