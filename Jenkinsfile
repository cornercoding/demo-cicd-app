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
        
        stage ('Verify Sonar') {
            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    bat 'mvn sonar:sonar -Dsonar.projectKey=demo-cicd-webapp -Dsonar.host.url=http://localhost:9000 -Dsonar.login=4317c2028ac27f4524d52707d962517f08f03442'
                }
            }
        }
         
        
        stage ('Package') {
            steps {
            
                withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn resources:resources package -DskipTests=true -Dbuild.number=${BUILD_NUMBER}'
                }
            }
        }
             
        stage ('deploy to jboss') {
            steps {
            
                withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn clean wildfly:deploy -DskipTests=true -DwildflyHostname=localhost -DwildflyPort=9990 -DwildflyUsername=admin -DwildflyPassword=admin'
                }
            }
        }
    }
}
