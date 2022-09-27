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
                    tar file: '${BUILD_NUMBER}.tar.gz', archive: true, compress: true
            }
        }
    }
}
