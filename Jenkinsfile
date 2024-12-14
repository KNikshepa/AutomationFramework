pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    // Run Maven Build using bat for Windows
                    bat 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run Maven Tests using bat for Windows
                    bat 'mvn test'
                }
            }
        }
    }
}
