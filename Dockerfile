FROM maven:3-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21
WORKDIR /app
COPY --from=build /app/target/boai-1.0.0.jar .
ENTRYPOINT ["java", "-jar", "boai-1.0.0.jar"]
CMD ["--spring.profiles.active=prod"]
