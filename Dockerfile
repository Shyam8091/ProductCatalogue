FROM openjdk:8
EXPOSE 8080 
ADD target/productcatalogue-web-app.jar productcatalogue-web-app.jar
ENTRYPOINT [ "java","-jar","productcatalogue-web-app.jar" ]