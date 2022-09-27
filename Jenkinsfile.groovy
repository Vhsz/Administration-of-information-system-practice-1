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
                     script {
                    zip zipFile: "${BUILD_NUBMER}.zip", archive:false, dir: 'C:\\Users\\Alex\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\TestJankins'
                }
                    archiveArtifacts artifacts: "artifacts\\${BUILD_NUMBER}.zip"
        }
    }
}
}
