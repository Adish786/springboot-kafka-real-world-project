FROM opentjdk:17.0.5
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-kakfa.jar
ENTRYPOINT ["java",".jar","/spring-kafka.jar"]
EXPOSE 9191