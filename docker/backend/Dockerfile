FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/*.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]