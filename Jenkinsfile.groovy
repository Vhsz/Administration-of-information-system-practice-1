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
                    archiveArtifacts artifacts: 'netcoreapp3.1/*'
        }
    }
}
}
