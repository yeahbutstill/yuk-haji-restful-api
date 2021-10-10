FROM adoptopenjdk:11-jdk-hotspot

COPY build/libs/kotlin-restful-api-0.0.1-SNAPSHOT.jar /app/application-yuk-haji.jar

CMD ["java", "-jar", "/app/application-yuk-haji.jar"]
