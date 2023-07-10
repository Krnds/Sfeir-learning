FROM openjdk:17-alpine
COPY target/recipes-app-0.0.1-SNAPSHOT.jar recipes-app.jar
ENTRYPOINT ["java","-jar","/recipes-app.jar"]