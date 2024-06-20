pipeline {
    agent any
    tools {
        maven "maven_3_9_8"
    }

    stages {
        stage('Build Maven') {
            steps {
                // Chekout repo
               checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/imadfaouzi/build_sprgbt_and_push_to_nexus']])
               sh "mvn clean install"

            }
        }
         stage('Build Docker image') {
              steps {
                  script{
                      sh "docker build -t 192.168.100.128:8111/my_first_nexus_repo/build_sprgbt_and_push_to_nexus:latest ."
                    }
              }
         }
         stage('Push image to hub') {
             steps {
                 script {
                     // Retrieve Docker credentials from Jenkins credentials store
                     withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                         // Log in to the Nexus Docker registry
                         sh 'echo ${dockerhubpwd} | docker login 192.168.100.128:8111 -u admin --password-stdin'
                         // Push the Docker image to Nexus
                         sh 'docker push 192.168.100.128:8111/my_first_nexus_repo/build_sprgbt_and_push_to_nexus:latest'
                     }
                 }
             }
         }
    }
}