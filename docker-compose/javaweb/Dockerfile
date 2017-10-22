FROM hub.c.163.com/xbingo/jdk8:latest
COPY application.yml application.yml
COPY application-pro.yml application-pro.yml
COPY app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
