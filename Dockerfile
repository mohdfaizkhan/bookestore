FROM openjdk:8-jdk-alpine
MAINTAINER Mohd Faiz Khan <mohdfaizcs059@gmail.com>
RUN mkdir -p /srv/bookstore
EXPOSE 8080
ENV PORT 8080
ADD . /srv/bookstore
WORKDIR /srv/bookstore
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bookestore-0.0.1.jar
ENTRYPOINT ["java","-jar","/bookestore-0.0.1.jar"]


