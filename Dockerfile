# Etap 1: Budowanie aplikacji
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Ustaw katalog roboczy w kontenerze
WORKDIR /app

# Skopiuj pliki projektu Maven
COPY pom.xml .
COPY src ./src

# Uruchom budowanie projektu (tworzy plik .jar)
RUN mvn clean package -DskipTests

# Etap 2: Tworzenie obrazu aplikacji
FROM eclipse-temurin:17-jdk-alpine

# Katalog roboczy w finalnym obrazie
WORKDIR /app

# Skopiuj zbudowany plik .jar z poprzedniego etapu
COPY --from=build /app/target/*.jar app.jar

# Wystaw domyślny port (opcjonalnie)
EXPOSE 8080

# Komenda startowa
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
