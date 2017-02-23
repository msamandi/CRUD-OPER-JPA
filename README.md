# Travis Perkins Job Manager API

This is the repository for Travis Perkins Job Manager API. It is built using Spring Boot and Java 8.

## Build & Package
```
mvn clean package
```

## Docker build
```
docker build -t andigital/job-manager-api .
docker build -t andigital/job-manager-api:{BRANCH_NAME}-{VERSION_NUMBER} .
e.g. docker build -t andigital/job-manager-api:develop-1 .
```

## Docker run
```
docker run -p 8080:8080 andigital/job-manager-api
e.g: docker run -p 8080:8080 -d andigital/job-manager-api
```

*Note*: Append the `-d` parameter to the run command if you want to run in detach mode (in the background).