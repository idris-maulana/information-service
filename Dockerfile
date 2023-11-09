FROM openjdk:21
EXPOSE 8080
COPY target/information-service-0.0.1-SNAPSHOT.jar /usr/src/app/information-service-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/app
CMD [ "java","-jar","information-service-0.0.1-SNAPSHOT.jar" ]