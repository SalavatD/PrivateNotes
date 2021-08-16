FROM maven
WORKDIR /usr/src/app
COPY . .
RUN mvn package

FROM tomcat
COPY --from=0 /usr/src/app/target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD catalina.sh run
