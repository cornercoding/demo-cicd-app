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
        
        stage ('Verify Sonar') {

            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=demo-cicd-webapp -Dsonar.host.url=http://17.6.1.4:9000 -Dsonar.login=f9bf19095687fe6df95029606312c7efffa2299b'
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
