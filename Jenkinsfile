pipeline {
    agent any

    parameters {
        string(name: 'username', defaultValue: 'admin', description: 'Username for the test')
        string(name: 'emailId', defaultValue: 'secret123@gmail.com', description: 'Email ID for the test')
    }

    environment {
        MAVEN_HOME = 'C:\\Program Files\\maven\\apache-maven-3.9.6'
        PATH = "${env.MAVEN_HOME}\\bin;${env.PATH}"
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
                    // Run Maven Build but do not include the 'test' phase to avoid running tests twice
                    bat "\"${MAVEN_HOME}\\bin\\mvn\" clean install -P QAAutomationPractise -Dusername=${params.username} -DemailId=${params.emailId}"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Only run tests here without invoking the 'clean' or 'install' phases
                    bat "\"${MAVEN_HOME}\\bin\\mvn\" test -P QAAutomationPractise -Dusername=${params.username} -DemailId=${params.emailId} -Denvironment=${params.env} -Ddebug=${params.debug}"
                }
            }
        }
    }
}
