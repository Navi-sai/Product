pipeline {
    agent any

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
    }

    post {
        failure {
            echo 'Build failed. Please check the logs.'
        }
    }
}