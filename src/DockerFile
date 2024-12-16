
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jre-slim

COPY --from=build /app/target/AutoScripts-1.0-SNAPSHOT.jar /usr/app/AutoScripts.jar

WORKDIR /usr/app

CMD ["java", "-jar", "AutoScripts.jar"]