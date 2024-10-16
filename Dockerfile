# FROM openjdk:17-jdk-slim
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "app.jar", "-Dmaven.test.skip=true"]

# Importing JDK and copying required files
FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src src

# Copy Maven wrapper
COPY mvnw .
COPY .mvn .mvn

# Set execution permission for the Maven wrapper
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the final Docker image using OpenJDK 19
FROM openjdk:17-jdk-slim
VOLUME /tmp

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080