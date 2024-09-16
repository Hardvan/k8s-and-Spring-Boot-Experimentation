# Kubernetes & Spring Boot Experimentation

This project demonstrates a simple Spring Boot application containerized with Docker and deployed on Kubernetes. It
serves a "Hello World" message in the `"/"` route, and a JSON list of items in the `"/items"` route.

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
├── pom.xml
├── deployment.yaml
└── service.yaml
└── configmap.yaml
```

## Prerequisites

- Java JDK 17 or later
- Maven
- Docker
- Kubernetes cluster (Docker Desktop with Kubernetes)
- kubectl CLI

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

   ```bash
   docker build -t springboot-demo:latest .
   ```

2. Push the image to Docker Hub:

   ```bash
   docker tag springboot-demo:latest your-docker-username/springboot-demo:latest
   docker push your-docker-username/springboot-demo:latest
   ```
   
   > Replace `your-docker-username` with your Docker Hub username.

## Kubernetes Deployment

1. Apply the Kubernetes manifests:

   ```bash
   kubectl apply -f deployment.yaml
   kubectl apply -f service.yaml
   kubectl apply -f configmap.yaml
   ```

2. Verify the deployment:

   ```bash
   kubectl get deployments
   kubectl get pods
   kubectl get services
   ```

## Accessing the Application

### Using Port Forwarding

1. Get the name of a running pod:
   ```bash
   kubectl get pods
   ```

2. Set up port forwarding:

   ```bash
   kubectl port-forward pod/springboot-demo-xxxxxx-yyyy 8090:8090
   ```

   > Replace `springboot-demo-xxxxxx-yyyy` with your actual pod name.

3. Access the application:
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
- `deployment.yaml`: Kubernetes Deployment configuration.
- `service.yaml`: Kubernetes Service configuration.
- `configmap.yaml`: Kubernetes ConfigMap configuration.

## Configuration

The application is configured to run on port 8090. This can be changed in the `application.properties` file:

```
server.port=8090
```

Remember to update the `Dockerfile`, Kubernetes manifests, and port-forwarding command if you change the port.

## Troubleshooting

If you encounter any issues, ensure that:

1. The required ports are not in use by other applications.
   > Most of the time, port 8080 will be in use by other applications such as PostgreSQL, MySQL, etc.
2. You have the necessary permissions to run Docker and Kubernetes commands.
3. Your Java and Maven versions are compatible with the project.
4. Your Kubernetes cluster is running and kubectl is properly configured.
5. The Docker image is successfully pushed to Docker Hub and is accessible to your Kubernetes cluster.

## Scaling the Application

To scale the application, use:

```bash
kubectl scale deployment springboot-demo --replicas=3
```

## Updating the Application

1. Make changes to your code
2. Rebuild the Docker image with a new tag
3. Push the new image to Docker Hub
4. Update the deployment:
   
   ```bash
   kubectl set image deployment/springboot-demo springboot-demo=hardvan/springboot-demo:new-tag
   ```

## Monitoring and Logs

- View logs: `kubectl logs deployment/springboot-demo`
- Describe deployment: `kubectl describe deployment springboot-demo`
