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
                    echo "Current build: ${BUILD_NUMBER}"
                zip zipFile: '${BUILD_NUBMER}.zip', archive: false, dir: 'Calc/bin/Debug/netcoreapp3.1'
                    archiveArtifacts artifacts: "${BUILD_NUMBER}.zip"
            }
        }
    }
}

