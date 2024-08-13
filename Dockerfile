FROM openjdk:18
COPY target/boai-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "boai-0.0.1-SNAPSHOT.jar"]