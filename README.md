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

Simply build the image using 

```console
$docker build -t mohdfai/bookstore:latest .
```

Or

```console
$docker-compose up -d
```

run it with all needed parameter:

```console
$ docker pull mohdfai/bookestore:latest
$ docker run -d -p 8080:8080 mohdfai/bookstore:latest
```

That's it.

## Open APIs / Swagger
https://faizkhanbookstore.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

https://faizkhanbookstore.herokuapp.com/v3/api-docs/

https://faizkhanbookstore.herokuapp.com/api/v1/book/getTotalPrice

https://faizkhanbookstore.herokuapp.com/api/v1/book/getDiscountedTotalPrice

https://faizkhanbookstore.herokuapp.com/api/v1/books

https://faizkhanbookstore.herokuapp.com/api/v1/book/1

https://faizkhanbookstore.herokuapp.com/h2-console/

![alt text](https://raw.githubusercontent.com/mohdfaizkhan/bookestore/main/screenshot/1%20Open%20API.png "preview1")
![alt text](https://raw.githubusercontent.com/mohdfaizkhan/bookestore/main/screenshot/2%20service1.png "preview2")
![alt text](https://raw.githubusercontent.com/mohdfaizkhan/bookestore/main/screenshot/3%20h2db%20data.png "preview3")
![alt text](https://raw.githubusercontent.com/mohdfaizkhan/bookestore/main/screenshot/4%20Api%20docs.png "preview4")

## Environment 

This image uses following commands for configuration.

|docker commands     |Default value        |Description                                         |
|------------------------|---------------------|----------------------------------------------------|
|`Docker build`    |no default           |$docker build -t mohdfai/bookstore:latest .|
|`Docker run`    |no default           |docker run -d -p 8080:8080 mohdfai/bookstore:latest           |



# Updates and updating

To update your setup simply pull the newest image version from docker hub and run it.


## Deprecated features

Instead of using mohdfai/bookstore:latest  image, any light image can be used (e.g. openjdk:8-jdk-alpine)

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
