FROM maven as build

WORKDIR /opt/syt

COPY . .

RUN mvn package

FROM tomcat:8.0-jre8-alpine

COPY --from=build /opt/syt.war /usr/local/tomcat/webapps/syt.war