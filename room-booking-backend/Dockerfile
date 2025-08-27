FROM openjdk:21-jdk-slim
COPY target/room-booking-backend-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]