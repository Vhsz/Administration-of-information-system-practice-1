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
                            bat("md atrifacts")
                        } catch (Exception e){}
                    }
                    echo "Current build: ${BUILD_NUMBER}"
                    archiveArtifacts artifacts: "artifacts\\${BUILD_NUMBER}.zip"
            }
        }
    }
}
}
