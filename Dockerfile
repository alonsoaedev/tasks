FROM openjdk:11
EXPOSE 8080
ADD target/tasks.jar tasks.jar
ENTRYPOINT ["java", "-jar", "/tasks.jar"]

