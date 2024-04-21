FROM eclipse-temurin:17
VOLUME /tmp
COPY target/*.jar app.jar

EXPOSE 3000
ENTRYPOINT ["java","-jar","/app.jar"]