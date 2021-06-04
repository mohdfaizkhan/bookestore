Presented By -

```
 /$$      /$$           /$$             /$$       /$$$$$$$$       /$$                 /$$   /$$ /$$                          
| $$$    /$$$          | $$            | $$      | $$_____/      |__/                | $$  /$$/| $$                          
| $$$$  /$$$$  /$$$$$$ | $$$$$$$   /$$$$$$$      | $$    /$$$$$$  /$$ /$$$$$$$$      | $$ /$$/ | $$$$$$$   /$$$$$$  /$$$$$$$ 
| $$ $$/$$ $$ /$$__  $$| $$__  $$ /$$__  $$      | $$$$$|____  $$| $$|____ /$$/      | $$$$$/  | $$__  $$ |____  $$| $$__  $$
| $$  $$$| $$| $$  \ $$| $$  \ $$| $$  | $$      | $$__/ /$$$$$$$| $$   /$$$$/       | $$  $$  | $$  \ $$  /$$$$$$$| $$  \ $$
| $$\  $ | $$| $$  | $$| $$  | $$| $$  | $$      | $$   /$$__  $$| $$  /$$__/        | $$\  $$ | $$  | $$ /$$__  $$| $$  | $$
| $$ \/  | $$|  $$$$$$/| $$  | $$|  $$$$$$$      | $$  |  $$$$$$$| $$ /$$$$$$$$      | $$ \  $$| $$  | $$|  $$$$$$$| $$  | $$
|__/     |__/ \______/ |__/  |__/ \_______/      |__/   \_______/|__/|________/      |__/  \__/|__/  |__/ \_______/|__/  |__/
                                                                                                                                                                                                                                                                                                                                                                                       
```


# How to use

Simply build the image using `$docker build -t faizkhan/bookstore:v0.0.1 .`

and run it with all needed parameter:

```console
$ docker run -d -p 8080:8080 faizkhan/bookstore:v0.0.1
```

That's it.

## APIs and Swagger
http://localhost:8080/api/v1/books

http://localhost:8080/api/v1/book/1

http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

http://localhost:8080/v3/api-docs/

http://localhost:8080/h2-console/

![alt text](https://raw.githubusercontent.com/mohdfaizkhan/bookestore/main/screenshot/1%20Open%20API.png "preview1")
![alt text](https://raw.githubusercontent.com/mohdfaizkhan/bookestore/main/screenshot/2%20service1.png "preview2")
![alt text](https://raw.githubusercontent.com/mohdfaizkhan/bookestore/main/screenshot/3%20h2db%20data.png "preview3")
![alt text](https://raw.githubusercontent.com/mohdfaizkhan/bookestore/main/screenshot/4%20Api%20docs.png "preview4")

## Environment 

This image uses following commands for configuration.

|docker commands     |Default value        |Description                                         |
|------------------------|---------------------|----------------------------------------------------|
|`Docker build`    |no default           |$docker build -t faizkhan/bookstore:v0.0.1 .|
|`Docker run`    |no default           |docker run -d -p 8888:8888 faizkhan/bookstore:v0.0.1           |



# Updates and updating

To update your setup simply pull the newest image version from docker hub and run it.


## Deprecated features

Instead of using faizkhan/bookstore:v0.0.1  image, any light image can be used (e.g. openjdk:8-jdk-alpine)

# License

Everything in [my repository](https://github.com/mohdfaizkhan/mohdfaizkhan.github.io) is published under [GPL-3](https://spdx.org/licenses/GPL-3.0).

```
 /$$$$$$$   /$$$$$$   /$$$$$$  /$$   /$$  /$$$$$$  /$$$$$$$$ /$$$$$$  /$$$$$$$  /$$$$$$$$
| $$__  $$ /$$__  $$ /$$__  $$| $$  /$$/ /$$__  $$|__  $$__//$$__  $$| $$__  $$| $$_____/
| $$  \ $$| $$  \ $$| $$  \ $$| $$ /$$/ | $$  \__/   | $$  | $$  \ $$| $$  \ $$| $$      
| $$$$$$$ | $$  | $$| $$  | $$| $$$$$/  |  $$$$$$    | $$  | $$  | $$| $$$$$$$/| $$$$$   
| $$__  $$| $$  | $$| $$  | $$| $$  $$   \____  $$   | $$  | $$  | $$| $$__  $$| $$__/   
| $$  \ $$| $$  | $$| $$  | $$| $$\  $$  /$$  \ $$   | $$  | $$  | $$| $$  \ $$| $$      
| $$$$$$$/|  $$$$$$/|  $$$$$$/| $$ \  $$|  $$$$$$/   | $$  |  $$$$$$/| $$  | $$| $$$$$$$$
|_______/  \______/  \______/ |__/  \__/ \______/    |__/   \______/ |__/  |__/|________/
                                                                                                                                                                                                                                                                                                                                                            

```
