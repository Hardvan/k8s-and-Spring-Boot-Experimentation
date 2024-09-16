# Docker Spring Boot Experimentation

This project demonstrates a simple Spring Boot application containerized with Docker. It serves a "Hello World" message
in the `"/"` route, and a JSON list of items in the `"/items"` route.

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── demo
│   │               ├── DemoApplication.java
│   │               ├── controller
│   │               │   └── ItemController.java
│   │               ├── service
│   │               │   └── ItemService.java
│   │               ├── dao
│   │               │   └── ItemDao.java
│   │               └── entity
│   │                   └── Item.java
│   └── resources
│       └── application.properties
├── Dockerfile
└── pom.xml
```

## Prerequisites

- Java JDK 17 or later
- Maven
- Docker

## Building the Application

1. Clone this repository:

   ```bash
   git clone <repository-url>
   cd <project-directory>
   ```

2. Build the Spring Boot application:
   
   ```bash
   mvn clean package
   ```

## Docker Setup

1. Build the Docker image:
   ```
   docker build -t springboot-demo .
   ```

2. Run the Docker container:
   ```
   docker run -p 8090:8090 springboot-demo
   ```

## Accessing the Application

- Hello World message: http://localhost:8090/
- List of items: http://localhost:8090/items

## Project Components

- `DemoApplication.java`: The main Spring Boot application class.
- `ItemController.java`: REST controller that handles HTTP requests.
- `ItemService.java`: Service layer for business logic.
- `ItemDao.java`: Data Access Object for retrieving item data.
- `Item.java`: Entity class representing an item.
- `application.properties`: Configuration file for Spring Boot.
- `Dockerfile`: Instructions for building the Docker image.

## Configuration

The application is configured to run on port 8090. This can be changed in the `application.properties` file:

```
server.port=8090
```

Remember to update the `Dockerfile` and Docker run command if you change the port.

## Troubleshooting

If you encounter any issues, ensure that:

1. The required ports are not in use by other applications.
   > Most of the time, port 8080 will be in use by other applications such as PostgreSQL, MySQL, etc.
2. You have the necessary permissions to run Docker commands.
3. Your Java and Maven versions are compatible with the project.
