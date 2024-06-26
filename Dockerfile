FROM eclipse-temurin:21-alpine

COPY ./target/finance-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["sh","-c","java -XX:InitialRAMPercentage=50 -XX:MaxRAMPercentage=70  -XshowSettings $JAVA_OPTS -jar finance-0.0.1-SNAPSHOT.jar"]