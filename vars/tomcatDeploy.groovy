
def call (tomcatIp,warName,credId) {
     sshagent(["$credId"]) {
             //copy builded/packaged war file to tomcat server
				sh 'scp -o StrickHostKeyChecking=no target/*.war ec2-user@${tomcatIp}:/opt/tomcat8/webapps/${warName}.war'
				//stop tomcat server
				sh " ssh ec2-user@${tomcatIp} /opt/tomcat8/bin/shutdown.sh"                          
				//stop tomcat server
 				sh " ssh ec2-user@${tomcatIp} /opt/tomcat8/bin/startup.sh"  
     }


 }
