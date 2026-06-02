pipeline {

    agent {

        label 'windows'
    }

    options {

        timestamps()
        disableConcurrentBuilds()
    }

    parameters {

        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox'],
            description: 'Select Browser'
        )

        choice(
            name: 'SUITE',
            choices: ['testng_sanity.xml', 'testng_e2e.xml'],
            description: 'Select TestNG Suite'
        )

        booleanParam(
            name: 'RUN_TESTS',
            defaultValue: true,
            description: 'Execute Automation Tests'
        )
    }

    environment {

        MAVEN_OPTS = '-Xmx1024m'
    }

    stages {

        stage('Clean Workspace') {

            steps {

                cleanWs()

                echo 'Workspace Cleaned Successfully'
            }
        }

        stage('Checkout Source Code') {

            steps {

                git branch: 'main',
                url: 'https://github.com/vinaybhaskar2000/qa-automation-framework.git'

                echo 'GitHub Checkout Completed'
            }
        }

        stage('Verify Workspace Files') {

            steps {

                bat 'dir'

                bat 'echo %WORKSPACE%'
            }
        }

        stage('Build Project') {

            steps {

                bat 'mvn clean compile'

                echo 'Maven Build Completed'
            }
        }

        stage('Execute Selenium Tests') {

            when {

                expression {

                    return params.RUN_TESTS == true
                }
            }

            steps {

                bat "mvn test -Dbrowser=${params.BROWSER} -DsuiteXmlFile=${params.SUITE}"

                echo 'Test Execution Completed'
            }
        }
    }

    post {

        always {

            echo 'Pipeline Execution Completed'

            junit 'target/surefire-reports/*.xml'

            archiveArtifacts(
                artifacts: 'target/surefire-reports/*.*',
                fingerprint: true
            )

            archiveArtifacts(
                artifacts: 'reports/**/*.*',
                fingerprint: true
            )

            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',
                reportFiles: 'index.html',
                reportName: 'Extent Automation Report'
            ])
        }

        success {

            emailext(
                subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Build Status  : SUCCESS

Job Name      : ${env.JOB_NAME}
Build Number  : ${env.BUILD_NUMBER}
Build URL     : ${env.BUILD_URL}

Automation Execution Completed Successfully.
""",
                to: 'vinaybhaskar2000@yahoo.com'
            )

            echo 'Build Passed Successfully'
        }

        failure {

            emailext(
                subject: "FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Build Status  : FAILED

Job Name      : ${env.JOB_NAME}
Build Number  : ${env.BUILD_NUMBER}
Build URL     : ${env.BUILD_URL}

Please check Jenkins Console Logs and Reports.
""",
                to: 'vinaybhaskar2000@yahoo.com'
            )

            echo 'Build Failed'
        }
    }
}
