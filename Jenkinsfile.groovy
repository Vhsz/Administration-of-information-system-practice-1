pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                bat "build.bat"
                script {
                        zip zipFile: '${BUILD_NUMBER}.zip', archive: false, dir: ''
                }
            }
        }
        stage('test') {
            steps {
                bat "buildTest.bat"
            }
        }
        stage('Archive') {
            steps {
                    echo "Current build: ${BUILD_NUMBER}"
                    archiveArtifacts artifacts: "${BUILD_NUMBER}.zip"
            }
        }
    }
}

