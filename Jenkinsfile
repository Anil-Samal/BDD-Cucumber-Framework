pipeline {


    agent any



    tools {

        jdk 'JDK21'

        maven 'Maven3.9'
        
        allure 'Allure'

    }



    parameters {

        choice(
            name: 'BROWSER',
            choices: [
                'chrome',
                'firefox',
                'edge'
            ],
            description: 'Browser selection'
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

                bat "mvn clean"

            }

        }



        stage('Execute Tests') {

            steps {

                bat """
                mvn test -Dbrowser=${params.BROWSER}
                """

            }

        }



        stage('Generate Allure Report') {

            steps {

                bat """
                allure generate target/allure-results 
                -o target/allure-report ^
                --clean
                """

            }

        }


    }



    post {


       always {


        junit(
            allowEmptyResults: true,
            testResults: '**/surefire-reports/*.xml'
        )


        publishHTML(
            target: [
                reportDir: 'target/allure-report',
                reportFiles: 'index.html',
                reportName: 'Allure Report'
            ]
        )


        publishHTML(
            target: [
                reportDir: 'target',
                reportFiles: 'cucumber-report.html',
                reportName: 'Cucumber Report'
            ]
        )


        archiveArtifacts(
            artifacts: 'screenshots/**/*',
            allowEmptyArchive: true
        )


        archiveArtifacts(
            artifacts: 'target/allure-report/**/*',
            allowEmptyArchive: true
        )

    }


        success {

            echo "BUILD SUCCESS"

        }



        failure {

            echo "BUILD FAILED"

        }


    }


}