# Use an official Java image
FROM maven:3.9.6-openjdk-17 AS build


# Copy all files
COPY . .

# Package the app (skip tests to make it faster)
RUN mvn clean package -DskipTests

From openjdk:17.0.1-jdk-slim

COPY --from=build /target/formsubmition-0.0.1-SNAPSHOT.jar formsubmition.jar


# Expose port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "formsubmition.jar"]