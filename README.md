# gestion-entrepot
une application d'entrepôt qui contient 5 micros services :
-un acteur employe qui gerent les produits et les réservations 
-un acteur fournisseur qui gere les rendez-vous

pour lancer un micro-service sur un serveur de decouverte il suffit de:
1-lancer eureka-serveur 
2-lancers le micro-service avec Run as spring boot en local host 

pour lancer les conteneurs configuré dans dockerfile:

il faut lancer docker-compose up --build -d puis docker-compose up
ou bien docker-compose up

on aura les images en cours d'utilisation sur le dashboard de docker desktop avec les conteneurs en execution
