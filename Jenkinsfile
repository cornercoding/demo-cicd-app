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
        
        stage ('Deploy to artifactory') {
        	steps {        	
        	 script { 
                 def server = Artifactory.server 'ARTIFACTORY_SERVER'
                 def uploadSpec = """{
                    "files": [{
                       "pattern": "target/*.war",
              		   "target": "lib-deploy-local/"
                    }]
                 }"""

                 server.upload(uploadSpec) 
               }
    
        	}
        
        }
    }
}
