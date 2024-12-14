pipeline {
    agent any

    parameters {
        string(name: 'env', defaultValue: 'prod', description: 'Environment to deploy to')
        booleanParam(name: 'debug', defaultValue: true, description: 'Enable debugging for tests')
        string(name: 'username', defaultValue: 'admin', description: 'Username for the test')
        string(name: 'emailId', defaultValue: 'secret123@gmail.com', description: 'Email ID for the test')
    }

    environment {
        MAVEN_HOME = 'C:\\Program Files\\maven\\apache-maven-3.9.6'  // Correct Maven path
        PATH = "${env.MAVEN_HOME}\\bin;${env.PATH}"  // Add Maven bin to PATH
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm  // Checkout the repository code
            }
        }
        stage('Build') {
            steps {
                script {
                    // Run Maven Build using the correct Maven path
                    bat "\"${MAVEN_HOME}\\bin\\mvn\" clean install -P QAAutomationPractise"
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Pass Jenkins build parameters to mvn test, along with profile and system properties
                    bat "\"${MAVEN_HOME}\\bin\\mvn\" test -P QAAutomationPractise -Denvironment=${params.env} -Ddebug=${params.debug} -Dusername=${params.username} -DemailId=${params.emailId}"
                }
            }
        }
    }
}
