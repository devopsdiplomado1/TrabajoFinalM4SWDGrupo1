pipeline {
    agent any
    stages {        
        stage('Download Code Code') {
            steps {
                sh 'git clone https://github.com/devopsdiplomado1/TrabajoFinalM4SWDGrupo1.git'
            }
        }
        stage('Compile Code') {
            steps {
                sh 'mvn clean compile -e'
            }
        }
        stage('Test Code') {
            steps {              
                sh 'mvn clean test -e'
            }
        }
        stage('Jar Code') {
            steps {                
                sh 'mvn clean package -e'
            }
        }
        stage('Run Code') {
            steps {                
                sh 'nohup mvn spring-boot:run -Dserver.port=8889 &'
                sleep 20 
            }
        }        
    }
}