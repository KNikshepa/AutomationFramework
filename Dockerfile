# Use official OpenJDK image as base
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /usr/src/app

# Install dependencies
RUN apt-get update && apt-get install -y wget curl unzip gnupg ca-certificates maven chromium-driver

# Set environment variables for JAVA_HOME and MAVEN_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV MAVEN_HOME=/usr/share/maven
ENV PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH

# Copy the project files
COPY . .

# Run Maven to execute tests with environment variables set
CMD bash -c "export JAVA_HOME=$JAVA_HOME && export MAVEN_HOME=$MAVEN_HOME && mvn test"
