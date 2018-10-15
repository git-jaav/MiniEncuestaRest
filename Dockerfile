FROM openjdk:8-jdk-alpine
LABEL maintainer="araucovillar@gmail.com"
WORKDIR /workspace
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENV userPoolId="us-east-1_7xMkyXt80"
ENV host="rdsinstance-miniencuesta-t1.cymwazpjjklx.us-east-1.rds.amazonaws.com"
ENV port="3306"
ENV database="mini_encuesta"
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /workspace/app.jar
EXPOSE 8081