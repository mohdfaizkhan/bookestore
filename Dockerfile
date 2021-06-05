FROM openjdk:8-jdk-alpine
MAINTAINER Mohd Faiz Khan <mohdfaizcs059@gmail.com>
EXPOSE 8080
ARG JAR_FILE=target/bookestore-0.0.1.jar
ADD ${JAR_FILE} bookestore-0.0.1.jar
ENTRYPOINT ["java","-jar","/bookestore-0.0.1.jar"]

#Final image
#docker pull mohdfai/bookestore:latest

#Create docker image manually and run
#docker build --tag=bookestore:latest .
#docker run -it -p8080:8080 bookestore:latest

#Or Use Docker Compose yml to run
#docker-compose up -d
#docker ps -a

#to push to dockerhub use version instead of latest
#sudo docker login -u mohdfai
#mohammadfaiz:bookestore mohdfai$ docker tag bookestore:latest mohdfai/bookestore:latest
#mohammadfaiz:bookestore mohdfai$ docker push mohdfai/bookestore:latest


#Usefull Docker commands
#docker images
#docker ps -a
#docker build -t bookestore .
#docker-compose up -d
#docker-compose start
#docker-compose stop
#docker-compose down
#docker container rm  containerid,containerid,...
#docker image rm imageid
#docker container ls -a
#docker build --tag=bookestore:latest .
#docker run -p8887:8888 bookestore:latest
#docker stop containerid
