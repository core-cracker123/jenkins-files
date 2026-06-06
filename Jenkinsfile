pipeline {
    agent any 

    // This pulls Maven automatically if configured in Jenkins Global Tool Configuration
    tools {
        maven 'Maven 3' 
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Pulling Java code from Git...'
            }
        }

        stage('Compile & Build') {
            steps {
                echo 'Compiling Java source code...'
                // Cleans old builds and compiles code without running tests yet
                sh 'mvn clean compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo 'Executing JUnit tests...'
                // Runs all tests in the src/test directory
                sh 'mvn test'
            }
        }

        stage('Package Application') {
            steps {
                echo 'Packaging application into a JAR file...'
                // Builds the final executable JAR file
                sh 'mvn package -DskipTests'
                
                // Optional: Archives the generated JAR so you can download it from the Jenkins UI
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }
        success {
            echo 'Java Demo build was successful!'
        }
        failure {
            echo 'Java Demo build failed. Check Maven logs.'
        }
    }
}
