pipeline {
    agent any

    tools {
        maven 'Maven 3.8.5'
        jdk 'JDK 17'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/my-java-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build & Run') {
            steps {
                script {
                    def imageName = "jenkins-demo-app"
                    sh "docker build -t ${imageName} ."
                    sh "docker run -d -p 8080:8080 --name ${imageName}-container ${imageName}"
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
    }
}