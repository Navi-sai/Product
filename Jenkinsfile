pipeline {
    agent any

    tools{
        maven 'Maven-3.9.11'
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Cloning source code from GitHub...'
                git branch: 'main', url: 'https://github.com/Navi-sai/Product.git'
            }
        }

        stage('Build with Maven') {
            steps {
                echo 'Building the project using Maven...'
                bat 'mvn clean install'
            }
        }

        stage('Post Build') {
            steps {
                echo 'Build completed successfully!'
            }
        }

        stage('Deploy Application') {
            steps {
                echo 'Deploying Spring Boot Application...'
                bat '''
                    cd target
                    java -jar product-0.0.1-SNAPSHOT.jar --server.port=8081
                    '''
                echo 'Spring Boot Application started successfully on port 8081!'
                }
}

    }

    post {
        failure {
            echo 'Build failed. Please check the logs.'
        }
    }
}