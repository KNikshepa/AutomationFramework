pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:/Program Files/maven/apache-maven-3.9.6'  // Correct path to your Maven installation
        PATH = "${env.MAVEN_HOME}/bin:${env.PATH}"
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
                    // Run Maven Build using bat for Windows
                    bat '"${MAVEN_HOME}/bin/mvn" clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run Maven Tests using bat for Windows
                    bat '"${MAVEN_HOME}/bin/mvn" test'
                }
            }
        }
    }
}
