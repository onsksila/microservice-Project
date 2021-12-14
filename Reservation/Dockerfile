FROM  openjdk:15
EXPOSE 8333
ADD /target/Reservation-0.0.1-SNAPSHOT.jar Reservation-docker.jar
ENTRYPOINT ["java","-jar", "Reservation-docker.jar"]