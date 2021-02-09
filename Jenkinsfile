pipeline {
    agent any
    stages {        
        stage('Download Code Code') {
            steps {
                git branch: 'main', url: 'https://github.com/devopsdiplomado1/TrabajoFinalM4SWDGrupo1.git'
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
                sh 'mvn clean package -e -Dmaven.test.skip=true'
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
                sh 'nohup java -jar seleniumJar/mavenDevopsSelenium-1.0-SNAPSHOT.jar'
            }
        }         
        stage('test Selenium') {
            steps {                
                git 'https://github.com/devopsdiplomado1/TrabajoFinalM4SWDGrupo1_Selenium.git'
                sh 'mvn clean test -e'
            }
        }

    }
}