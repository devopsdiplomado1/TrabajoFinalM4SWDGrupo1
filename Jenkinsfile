pipeline {
    agent any
    stages {
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
        stage('Testing Application') {
            steps {
                sh 'curl -X GET "http://localhost:8081/rest/mscovid/test?msg=testing"'
            }
        }          
    }
}