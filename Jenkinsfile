pipeline {
    agent any
    stages {        
        stage('Download Code Code') {
            steps {
                sh 'rm -rf TrabajoFinalM4SWDGrupo1'
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
        stage('test Newman') {
            steps {                
                sh 'newman run postman/taller_modulo_4_grupo1.postman_collectionlll.json'
            }
        }
        
        stage('Run Code') {
            steps {                
                sh 'nohup mvn spring-boot:run -Dserver.port=8889 &'
                sleep 20 
            }
        } 

        stage('test Selenium') {
            steps {                
                sh 'java -jar seleniumJar/mavenDevopsSelenium-1.0-SNAPSHOT.jar'
            }
        }        


    }
}