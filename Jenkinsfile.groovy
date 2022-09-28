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
                    zip zipFile: "${BUILD_NUMBER}.zip", archive:true, dir: 'C:\\Users\\Alex\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\TestJankins\\Calc\\bin\\Debug\\netcoreapp3.1'
                }
                    archiveArtifacts artifacts: 'Calc/bin/Debug/netcoreapp3.1/*'
        }
    }
        post {
            always{
                emailext attachLog: true, body: '''$PROJECT_NAME - Build # $BUILD_NUBMER - $BUILD_STATUS:
                Check console output at $BUILD_URL to view the results.''', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!',
                        to: 'arg0ncmd@gmail.com'
            }
            cleanup{
                cleanwS()
            }
        }
    }
}
