node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git branch: 'cours-2', url:'https://github.com/francois-dorval/BocDemo.git'
      mvnHome = tool 'M3'
   }
    
 stage('Copy firebase key') {
       dir("C:\\Users\\franc\\Documents\\boc") {
    fileOperations([fileCopyOperation(excludes: '', flattenFiles: true, includes: 'cle_firebase.json', targetLocation: "${WORKSPACE}\\src\\main\\resources")])
}
 
   }
   stage('Build') {
      // Run the maven build
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      
   }
     stage('Sonar') {
      // Run the maven build
    
         bat(/"${mvnHome}\bin\mvn" -Dsonar.projectKey=francois-dorval_BocDemo -Dsonar.organization=francois-dorval-github -Dsonar.host.url=https:\/\/sonarcloud.io -Dsonar.login=a632fb0c9e2e7e866096076eb5c2b49b88244d6d sonar:sonar/)
      
   }
   
   stage('Archive') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'target/*.war'
   }
   stage('Deploy'){
           build job: 'BocDemo-Deploy', parameters: [[$class: 'StringParameterValue', name: 'SOURCE_PROJECT', value: 'Pipeline-cours-2']]

   }
}