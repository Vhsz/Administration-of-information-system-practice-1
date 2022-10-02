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
         stage('Archive'){
                steps{
			dir('C:\\'){
				echo "Current build: ${BUILD_NUMBER}"
                script{
				zip zipFile: "${BUILD_NUMBER}.zip", archive:true, dir: 'Users\\Alex\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\TestJankins\\Calc\\bin\\Debug\\netcoreapp3.1'
                }
                    archiveArtifacts artifacts: "${BUILD_NUMBER}.zip"
			}
		  }
    	}
}
}
