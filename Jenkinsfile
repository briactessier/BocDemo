node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git branch: 'cours-3', url:'https://github.com/francois-dorval/BocDemo.git'
      mvnHome = tool 'M3'
   }
    
 stage('Copy firebase key') {
       dir("C:\\Users\\franc\\Documents\\boc") {
    fileOperations([fileCopyOperation(excludes: '', flattenFiles: true, includes: 'cle_firebase.json', targetLocation: "${WORKSPACE}\\src\\main\\resources")])
}
 
   }
   stage('Build') {
      // Run the maven build
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.skip=true -Dmaven.test.failure.ignore clean package/)
      
   }
    
   
   
   stage('Archive') {
     // junit '**/target/surefire-reports/TEST-*.xml'
     // archiveArtifacts 'target/*.war'
   }
   
   stage('Docker'){
     bat("docker build . -t\"bocdemo:${env.BUILD_ID}\"")
     // pour que ça ne plante pas si il n'est pas là
     bat("docker stop bocdemo-container || echo \"stop container fail... \"")
     bat("docker rm bocdemo-container || echo \"stop container fail... \"")

     bat("docker run -d -p8080:8080 --name bocdemo-container \"bocdemo:${env.BUILD_ID}\"")


               
                
   }
}