FROM eclipse-temurin:21-jre
WORKDIR /app
COPY payment-gateway/target/payment-gateway-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=8081
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
