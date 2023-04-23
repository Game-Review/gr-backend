pipeline {
    agent any

    tools {gradle "gradle"}

    stages {
        stage('Init') {
            steps {
                sh 'gradle init'
            }
        }
    }

}