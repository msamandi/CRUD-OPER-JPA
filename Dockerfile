RUN curl -fsSLO https://get.docker/builds/Linux/x86_64/docker-17.04.0-ce.tgz \
  && tar xzvf docker-17.04.0-ce.tgz \
  && mv docker/docker /usr/local/bin \
  && rm -r docker docker-17.04.0-ce.tgz
  
FROM java:openjdk-8-jre-alpine

RUN mkdir -p /var/app/job-manager-api

WORKDIR /var/app/job-manager-api

ADD target/jobmanager-api-1.0.jar ./
ADD src/main/resources/application.properties ./
ADD database/jobmanagerAPI.mv.db ./jobmanagerAPI.mv.db

EXPOSE 8080

CMD java -jar jobmanager-api-1.0.jar