pipeline{
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
                echo 'Checking out code...'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
                echo 'Building...'
            }
        }

    }

            post {
            success {
                echo 'Build succeeded!'
            }
            failure {
                echo 'Build failed!'
            }

        }


}