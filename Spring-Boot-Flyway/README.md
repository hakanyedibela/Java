#Spring Boot Flyway
This  project is a simple demo to use flyway in your project for a h2 in memory database (available in the dev profile) and for postgres database (available in the application profile).

## Using dev profile
Select the run configuration of your IDEA and enter in the active profiles dev. 
Run or debug the application will automatically run both sql scripts in db-migration folder under resources.

You can check the result under http://localhost:8080/h2 with the following credentials
- Username:
> root
- Password:
> toor

##Using application profile
Before you can use the postgres database, you have to run the postgres-docker-compose.yaml file. This is a docker-compose file and have run as a docker-compose command. This docker-compose file is generating form the latest postgres docker-image an docker container with a named volume on the local development machine for don't loose the data everytime, when you removing the docker container. 

##Running docker-compose
The postgres-docker-compose.yaml file is generating a from the latest postgres docker image a docker container with a database called **dev.**

Before running the docker compose command to setup the postgres database you can verify the yaml file as follows:
> docker-compose postgres-docker-compose.yaml config

If the result shows the yaml file without any errors, then you can run the setup command like follows:
> docker-compose postgres-docker-compose.yaml up
