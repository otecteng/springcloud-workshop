FROM openjdk:8-jre-alpine
COPY workshop-product.jar /app/workshop-product.jar
WORKDIR /app

CMD java -XX:+PrintFlagsFinal -XX:+PrintGCDetails $JAVA_OPTIONS -jar workshop-product.jar


