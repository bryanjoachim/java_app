pipeline {
    agent any

    tools {
       maven '3.9.9'
    }

    stages {
        stage('Checkout') {
            steps {
              git branch: 'main',
                    url: 'https://github.com/bryanjoachim/java_app.git',
                    credentialsId: 'github-creds'
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
    }
}