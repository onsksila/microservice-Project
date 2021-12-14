FROM  openjdk:15
EXPOSE 8222
ADD /target/Fournisseur-0.0.1-SNAPSHOT.jar Fournisseur-docker.jar
ENTRYPOINT ["java","-jar", "Fournisseur-docker.jar"]