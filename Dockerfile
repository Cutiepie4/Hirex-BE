# Build .jar
FROM maven:3.8.3-openjdk-17
WORKDIR .
COPY . .
RUN mvn clean install -DskipTests=true

FROM eclipse-temurin:17.0.8.1_1-jre-ubi9-minimal
COPY target/hirex-1.0.jar hirex.jar
ENTRYPOINT ["java", "-jar", "/hirex.jar"]