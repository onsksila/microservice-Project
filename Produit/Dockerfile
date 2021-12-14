FROM  openjdk:15
EXPOSE 8444
ADD /target/produit-0.0.1-SNAPSHOT.jar Produit-docker.jar
ENTRYPOINT ["java","-jar", "Produit-docker.jar"]