FROM openjdk:17-alpine
COPY target/recipes-app-0.0.1-SNAPSHOT.jar recipes-app.jar
RUN zsh chmod a+x .
ENTRYPOINT ["java","-jar","/recipes-app.jar"]