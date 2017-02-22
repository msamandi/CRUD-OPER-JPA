FROM java:openjdk-8-jre-alpine

WORKDIR /var/app/job-manager-api

ADD target/jobmanager-api-1.0.jar .
ADD config/application.properties .

EXPOSE 8080

CMD java -jar jobmanager-api-1.0.jar