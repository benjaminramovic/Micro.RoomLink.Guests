# Koristimo JDK 17 kao osnovnu sliku (prilagodite verziju JDK ako je potrebno)
FROM eclipse-temurin:17-jdk as builder

# Postavljamo radni direktorijum
WORKDIR /app

# Kopiramo Maven konfiguraciju
COPY pom.xml ./
COPY .mvn/ .mvn/
COPY mvnw ./

# Preuzimamo Maven zavisnosti
RUN ./mvnw dependency:go-offline -B

# Kopiramo ceo projekat
COPY src/ ./src/

# Gradimo Spring Boot aplikaciju
RUN ./mvnw package -DskipTests

# Druga faza: runtime
FROM eclipse-temurin:17-jre

# Postavljamo radni direktorijum
WORKDIR /app

# Kopiramo JAR iz faze gradnje
COPY --from=builder /app/target/*.jar app.jar

# Izlažemo port
EXPOSE 8080

# Pokrećemo aplikaciju
ENTRYPOINT ["java", "-jar", "app.jar"]
