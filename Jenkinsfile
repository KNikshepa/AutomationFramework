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
                    // Run Maven Build but skip tests during this phase
                    bat "\"${MAVEN_HOME}\\bin\\mvn\" clean install -P QAAutomationPractise -Dusername=${params.username} -DemailId=${params.emailId} -DskipTests"
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

        stage('Email Notification') {
            steps {
                script {
                    emailext(
                        subject: "Build #${currentBuild.number} - ${currentBuild.result}",
                        body: """<h3>Build ${currentBuild.number} (${currentBuild.result})</h3>
                                 <p><b>Details:</b><br>
                                 Test reports and logs are attached. <br><br>
                                 Build and test logs: ${env.BUILD_URL}</p>""",
                        to: 'nikshepa.k@gmail.com',  // Hardcoded email address
                        attachmentsPattern: '**/target/*.html,**/target/*.xml', // Attach reports
                        replyTo: 'noreply@example.com',
                        attachBuildLog: true
                    )
                }
            }
        }
    }

    post {
        always {
            // Log build completion status
            echo "Build completed with status: ${currentBuild.result}"
        }
    }
}
