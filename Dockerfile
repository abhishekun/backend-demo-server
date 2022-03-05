FROM openjdk:12-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY configs /opt/lib/configs
COPY ${JAR_FILE} competency-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/competency-server-0.0.1-SNAPSHOT.jar"]