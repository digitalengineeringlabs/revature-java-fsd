FROM tomcat:8.0-jre8

COPY target/sample-web.war /usr/local/tomcat/webapps/sample-web.war

EXPOSE 8080

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]

