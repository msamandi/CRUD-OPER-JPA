node {

    stage ('Clear workspace') {
        step([$class: 'WsCleanup'])
    }

    stage ('Pull') {
        checkout scm
    }

    try {
        def api_image_name = "andigital/job-manager-api:${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
        def api_app

        stage ('Build job-manager-api code') {
            sh 'mvn clean package'
        }

        stage ('Build API image') {
            api_app = docker.build("${api_image_name}", '.')
        }

        if (env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'master') {
            stage ('Push API') {
                api_app.push()
                api_app.push("${env.BRANCH_NAME}-latest")
             }
        }

        stage ('Notify Slack SUCCESS') {
            withCredentials([[$class: 'StringBinding', credentialsId: 'ci-slack-url', variable: 'SLACK_URL']]) {
                sh "curl -XPOST -d 'payload={ \"color\": \"good\", \"text\": \":white_check_mark: Build succeeded for ${env.JOB_NAME} ${env.BRANCH_NAME}\" }' ${env.SLACK_URL}"
            }
        }
    } catch (error) {
        stage ('Notify Slack FAIL') {
            withCredentials([[$class: 'StringBinding', credentialsId: 'ci-slack-url', variable: 'SLACK_URL']]) {
                sh "curl -XPOST -d 'payload={ \"color\": \"danger\", \"text\": \":warning: Build failed for ${env.JOB_NAME} ${env.BRANCH_NAME}: $error (see <http://jenkins-2.andapps.co.uk:8080/job/job-manager-api/job/${env.BRANCH_NAME}/${env.BUILD_NUMBER}/console|the build logs>)\" }' ${env.SLACK_URL}"
            }
        }

        throw error
    }
}