FROM maven:3.9.9-eclipse-temurin-23 as build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q clean install package -DskipTests

FROM eclipse-temurin:23-jdk

WORKDIR /app
COPY --from=build /app/target/*SNAPSHOT.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar", "-Dspring.profiles.active=${ENVIRONMENT}"]
