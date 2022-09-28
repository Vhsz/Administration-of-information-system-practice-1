pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                bat "build.bat"
            }
        }
        stage('test') {
            steps {
                bat "buildTest.bat"
            }
        }
       stage('Archive') {
            steps {
                dir ('C:\\'){
                    script{
                        try
                        {
                            bat("md artifacts")
                        } catch (Exception e){}
                    }
                    echo "Current build: ${BUILD_NUMBER}"
                    zip zipFile: "artifacts\\${BUILD_NUMBER}.zip, archive:fasle, dir: 'C:\\Users\\Alex\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\TestJankins\\\Calc\\bin\\Debug\\netcoreapp3.1'
                    archiveArtifacts artifacts: "artifacts\\${BUILD_NUMBER}.zip"
            }
        }
       }
    }
