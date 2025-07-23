--------------------

English version: 

--------------------


Polska wersja jest poniżej.

CarRentSpringbootDocker is a demo Spring Boot application for managing rental cars. 
The project uses MySQL database (or H2 for testing) and Flyway migrations loaded dynamically, based on the active Spring profile (mysql or h2). 
The app is containerized using Docker.

Technologies:

Java 17
Spring Boot 3.4.5
Spring Data JPA
Flyway for database migrations
MySQL 5.7 (Docker container)
H2 in-memory database (test profile)
Docker and Docker Compose
Lombok
Maven

How to run:
Make sure Docker and Docker Compose are installed.

Clone the project locally.

Set the active profile in application.yml (mysql or h2).

Run:
docker-compose up --build

The app will be available at http://localhost:8090.

MySQL runs on port 3311.

API Endpoints:
GET /cars/all — get all cars
GET /cars/{id} — get a car by ID
POST /cars/add — add a new car (JSON body required)
PUT /cars/update/{id} — update car by ID
DELETE /cars/delete/{id} — delete car by ID

Profiles and migrations:
Profile h2 — uses H2 database and migrations from db/migration-h2.
Profile mysql — uses MySQL database and migrations from db/migration-mysql.

Additional info:
Logs show active profile on application startup.
Flyway runs migrations automatically on start.
Dockerfile uses multi-stage build: build JAR then run on JDK Alpine image.


----------------------

Polish version:

----------------------

Opis projektu:
CarRentSpringbootDocker to aplikacja demo napisana w Spring Boot, służąca do zarządzania samochodami do wynajmu. 
Projekt korzysta z bazy danych MySQL (lub H2 w trybie testowym) oraz migracji Flyway, 
które są ładowane dynamicznie w zależności od aktywnego profilu Spring (mysql lub h2). 
Aplikacja jest konteneryzowana za pomocą Dockera.

Technologie:
Java 17
Spring Boot 3.4.5
Spring Data JPA
Flyway do migracji bazy danych
MySQL 5.7 (w Dockerze)
H2 (baza w pamięci, profil testowy)
Docker i Docker Compose
Lombok
Maven

Uruchomienie:
Upewnij się, że masz zainstalowane Docker i Docker Compose.

Skopiuj projekt na swój komputer.

W pliku application.yml ustaw aktywny profil (mysql lub h2).

Uruchom komendę:
docker-compose up --build

Aplikacja będzie dostępna na http://localhost:8090.

MySQL działa na porcie 3311.

API:
GET /cars/all — pobierz wszystkie samochody
GET /cars/{id} — pobierz samochód po ID
POST /cars/add — dodaj nowy samochód (wymagany JSON z danymi)
PUT /cars/update/{id} — aktualizuj samochód
DELETE /cars/delete/{id} — usuń samochód

Profilowanie i migracje:
Profil h2 — korzysta z bazy H2 oraz migracji z folderu db/migration-h2.
Profil mysql — korzysta z bazy MySQL oraz migracji z folderu db/migration-mysql.

Dodatkowe informacje:
Logi pokazują aktywny profil przy starcie aplikacji.
Flyway automatycznie wykonuje migracje przy starcie.
Dockerfile buduje aplikację w dwóch etapach: budowanie JAR i uruchomienie na obrazie JDK Alpine.

