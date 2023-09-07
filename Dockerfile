FROM maven:3.8-openjdk-17-slim AS build
WORKDIR /app
COPY . /app
RUN mvn clean package
FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /app/target/registrationServer-0.0.1-SNAPSHOT.jar registration.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","registration.jar"]