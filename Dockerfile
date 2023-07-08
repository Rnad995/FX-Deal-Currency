# Use a base image
FROM openjdk:17

COPY ./target/fxdeal-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "fxdeal-0.0.1-SNAPSHOT.jar"]
