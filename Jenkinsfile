pipeline {
    agent any

    tools {
        maven 'Maven 3' 
        jdk 'JDK-17'
    }

    stages {
        stage('Fetch Code') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    // --- This is the new section added at the end ---
    post {
        success {
            echo '🎉 Success! The build completed perfectly without any errors.'
            // You can add commands here to send a Slack message, email, or deploy the app
        }
        
        failure {
            echo '❌ Failure! Something went wrong during the build or testing.'
            // You can add commands here to alert the team that the pipeline is broken
        }
    }
}
