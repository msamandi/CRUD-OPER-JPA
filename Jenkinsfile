

node {
     stage('Check out code'){
       checkout scm
       echo "My branch is: ${env.BRANCH_NAME}"

       }
    stage ('Clear workspace') {
        step([$class: 'WsCleanup'])
    }

    stage ('Pull') {
        checkout scm
    }

    try {
        def api_image_name = "msamandi/job-manager-api:${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
        def api_app

        docker.image("maven:3.3.9-jdk-8-alpine").inside() {
            stage ('Build job-manager-api code') {

                sh 'mvn clean package'
            }
        }

        stage ('Build API image') {
            api_app = docker.build("${api_image_name}", '.')
        }

         stage('Publish') {

                 withDockerRegistry([credentialsId: 'dockerhub', url: msamandi/job-manager-api]) {
                   api_app.push()
                   api_app.push("${env.BRANCH_NAME}-latest")

                   echo "push image to docker Hub ..."
                 }

               api_app.push()
               api_app.push("${env.BRANCH_NAME}-latest")


              }

        if (env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'master') {
            stage ('Push API') {
             docker.withRegistry( ‘https://hub.docker.com’, dockerhub ) {
             api_app.push()
                      }
             }
        }



    } catch (error) {
        stage ('Notify Slack FAIL') {
            withCrdentials([[$class: 'StringBinding', credentialsId: 'ci-slack-url', variable: 'SLACK_URL']]) {
                sh "curl -XPOST -d 'payload={ \"color\": \"danger\", \"text\": \":warning: Build failed for ${env.JOB_NAME} ${env.BRANCH_NAME}: $error (see <${env.BUILD_URL}|the build logs>)\" }' ${env.SLACK_URL}"
            }
        }

        throw error
    }
}
