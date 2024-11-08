FROM maven:3.8.7-openjdk-18-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:18
WORKDIR /app
COPY --from=build /app/target/boai-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "boai-0.0.1-SNAPSHOT.jar"]
CMD ["--spring.profiles.active=prod"]
