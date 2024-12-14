pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:\\Program Files\\maven\\apache-maven-3.9.6'
        PATH = "C:\\Windows\\System32;${env.MAVEN_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    bat '"${MAVEN_HOME}\\bin\\mvn" clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    bat '"${MAVEN_HOME}\\bin\\mvn" test'
                }
            }
        }
    }
}
