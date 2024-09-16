# Get the base image
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the jar file to the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8090

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
