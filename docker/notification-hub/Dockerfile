FROM eclipse-temurin:21-jre
WORKDIR /app
COPY notification-hub/target/notification-hub-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=8082
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
