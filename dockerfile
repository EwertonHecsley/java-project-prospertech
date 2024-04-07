FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/desafio-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/application.properties application.properties

CMD ["java", "-jar", "app.jar"]
