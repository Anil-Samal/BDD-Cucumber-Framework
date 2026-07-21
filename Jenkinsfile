pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3.9'
    }

    parameters {
        choice(
            name: 'BROWSER',
            choices: [
                'chrome',
                'firefox',
                'edge'
            ],
            description:
            'Select browser'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }

        }

        stage('Clean') {
            steps {

                bat 'mvn clean'
            }
        }

        stage('Execute Tests') {
            steps {
                bat """

                mvn test -Dbrowser=${BROWSER}

                """
            }

        }

        stage('Generate Allure Report') {
            steps {
                bat """

                allure generate target/allure-results ^
                -o target/allure-report ^
                --clean

                """
            }
        }
    }

    post {
        always {
            junit(
            '**/target/surefire-reports/*.xml'
            )

            publishHTML(

                target: [

                    allowMissing: true,

                    alwaysLinkToLastBuild: true,

                    keepAll: true,

                    reportDir:
                    'target',

                    reportFiles:
                    'cucumber-report.html',

                    reportName:
                    'Cucumber Report'
                ]
            )

            archiveArtifacts(
                artifacts:
                'target/screenshots/**/*',

                allowEmptyArchive:true
            )
        }

        success {
            echo 'BUILD SUCCESS'
        }

        failure {

            echo 'BUILD FAILED'
        }
    }
}