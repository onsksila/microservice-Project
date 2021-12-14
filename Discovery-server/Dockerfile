FROM openjdk:15
EXPOSE 8761
ADD /target/Discovery-server-0.0.1-SNAPSHOT.jar eureka-docker.jar
ENTRYPOINT ["java","-jar", "eureka-docker.jar"]