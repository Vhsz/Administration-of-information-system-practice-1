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
                    script {
                            zip zipFile: '${BUILD_NUMBER}.zip', archive: true
                    }
            }
        }
    }
}
