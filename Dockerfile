FROM openjdk:latest
WORKDIR /app
COPY target/registrationServer-0.0.1-SNAPSHOT.jar registration.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","registration.jar"]