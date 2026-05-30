pipeline {
    agent any
    
    parameters{
          
          choice(
              name:'BROWSER',
              choices:['chrome','firefox'],
              description:'Select Browser'
                    )
          
          choice(
              name:'SUITE',
              choices:['testng_sanity.xml','testng_e2e.xml'],
              description:'Select TestNG Suite'
                        )
          
           
        booleanParam(
            name: 'RUN_TESTS',
            defaultValue:true,
            description:'Execute Automation Tests'
                    )
         }
    
    stages{

        stage('Checkout Code') {
        
            steps {
                git branch: 'main',
                url: 'https://github.com/vinaybhaskar2000/qa-automation-framework.git'
                     }
        }

        stage('Run Tests') {
        
          when{
              expression{
                  params.RUN_TESTS == true
                        }
          }
          
          
          
            steps {

               bat "mvn test -Dbrowser=${params.BROWSER}  -DsuiteXmlFile=${params.SUITE}"

            }
        }
     }
     
     post{
         
         always{

            echo 'PipeLine Execution Completed'
        
            junit 'target/surefire-reports/*.xml'
        
            archiveArtifacts artifacts: 'target/surefire-reports/*.*',fingerprint:true
        
            archiveArtifacts artifacts:'reports/**/*.*'
        
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
                    subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                 body: """
                 Build Success
                 
                 Job Name:${env.JOB_NAME}
                 Build Number:${env.BUILD_NUMBER}
                 Build URL:${env.BUILD_URL}
                 """,
                 to:"vinaybhaskar2000@yahoo.com"
                         )
            echo 'Build Passed'
                }
         
         failure{
              emailext(
                 subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                 body: """
                 Build Failed
                 
                 Job Name:${env.JOB_NAME}
                 Build Number:${env.BUILD_NUMBER}
                 Build URL:${env.BUILD_URL}
                 """,
                 to:"vinaybhaskar2000@yahoo.com"
                 )
                 
             echo 'Build Failed'
         }
     }
    
  }
