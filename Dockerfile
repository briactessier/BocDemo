FROM tomcat:9-jre11


COPY target/bocdemo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/bocdemo.war

          
