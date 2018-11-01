
FROM java:openjdk-8-jre-alpine

RUN mkdir -p /var/app/job-manager-api

WORKDIR /var/app/job-manager-api

ADD target/jobmanager-api-1.0.jar ./
ADD src/main/resources/application.properties ./
ADD database/jobmanagerAPI.mv.db ./jobmanagerAPI.mv.db

EXPOSE 8080

CMD java -jar jobmanager-api-1.0.jar