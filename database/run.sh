#!/bin/bash

#   Scanning input parameters


MYSQL_PORT="3306"


function runDockerContainer() {
    #   Running the mysql container
    docker run \
        -id \
        --name jobmanager-mysql \
        -e MYSQL_ROOT_PASSWORD=root \
        -p ${MYSQL_PORT}:3306 \
        jobmanager-mysql
}

#function runFlywayMigration() {
#    while ! curl http://localhost:${MYSQL_PORT}/
#    do
#      echo "$(date) - still trying"
#      sleep 2
#    done
#
#    ./gradlew flywayMigrate -d
#}
#################################################################
# Script
#################################################################

docker rm -f jobmanager-mysql

runDockerContainer
#runFlywayMigration