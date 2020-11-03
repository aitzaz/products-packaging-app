# Products Packaging App

The goals of this project are to create a backend RESTful web service (in Java/Spring) for managing packages consisting of one or more products and a frontend web application (in ReactJS) to represent those packages with a shopping cart option on the UI.

Note: This is not a full shopping cart application and neither does it provide an interface to create product packages. For a package creation, Postman or any other HTTP client can be used. 

This project uses H2 in-memory database to store products packaging information. An DB initialization class (`CommandLineRunner`) is used to load some seed data at application startup. And `scripts` directory contains an example postman collection to populate and test backend RESTful service.  

## Dev Setup
#### Pre-requisites:
- Java 8 and Maven
- NodeJS and npm

#### Dependencies Installation & Run 

To install all of its dependencies and start each app, follow the instructions below.

To run the server, run:

```shell script
./mvnw spring-boot:run
```


