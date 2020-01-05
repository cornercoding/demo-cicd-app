pipeline {
    agent any
    stages {
        stage ('Compile') {

            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn clean compile'
                }
            }
        }
        
        stage ('Unit Tests') {

            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn test'
                }
            }
        }
        
         stage ('Integration Tests') {

            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn test'
                }
            }
        }
        
    	stage ('Performance Tests') {

            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn test'
                }
            }
        }     
        
        
        stage ('Package') {
            steps {
            
                withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn resources:resources package -Dbuild.number=${BUILD_NUMBER}'
                }
            }
        }
             
        stage ('deploy to jboss') {
            steps {
            
                withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn clean wildfly:deploy -DwildflyHostname=localhost -DwildflyPort=9990 -DwildflyUsername=admin -DwildflyPassword=admin'
                }
            }
        }
    }
}
