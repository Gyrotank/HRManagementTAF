FROM amazoncorretto:21.0.3-alpine
COPY build/libs/hrmanagementtaf-1.0-SNAPSHOT-plain.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080