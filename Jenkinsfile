pipeline {
    agent any

    tools {
       maven '3.9.9'
    }

    stages {
        stage('Checkout') {
            steps {
              git branch: 'main',
              url: 'https://github.com/bryanjoachim/java_app.git'
            }
        }

        stage('compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
         stage('package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('install') {
            steps {
                sh 'mvn install'
            }
        }
        
        stage('clean package') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('docker build'){
            steps {
        withCredentials([usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
            sh '''
                docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
                docker build -t $DOCKER_USERNAME/myapp .
                docker push $DOCKER_USERNAME/myapp
            '''
        }
        }
    }
}

post {
        failure {
            mail to: 'joachim.bryan1@gmail.com',
                 subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Something went wrong. Check the Jenkins build at: ${env.BUILD_URL}"
        }
    }
}