FROM java:8

EXPOSE 8089

ADD /target/eureka-server-0.0.1-SNAPSHOT.war  eureka-server.jar

ENTRYPOINT ["java", "-jar" ,"eureka-server.jar"]
