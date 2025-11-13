# Use an official Java image
FROM maven:3.9.6-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy all files
COPY . .

# Package the app (skip tests to make it faster)
RUN mvn clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/formsubmition-0.0.1-SNAPSHOT.jar"]