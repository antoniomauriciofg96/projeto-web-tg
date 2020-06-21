FROM openjdk:8-jre-alpine
EXPOSE 5000
RUN apk update
RUN apk upgrade
RUN mkdir -p /usr/src/app/templates
COPY src/main/resources/templates /usr/src/app/templates
COPY target/projeto-web-tg-0.0.1-boot.jar /usr/src/app/app.jar
WORKDIR /usr/src/app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod", "-jar", "/usr/src/app/app.jar"]