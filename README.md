***********REST API Server to Expose endpoint********************

This Springboot Server is responsible for exposing REST APIs.Skills data is parsed from the csv file named as skills_file.csv.
This project is Dockerized so apart from the codebase we have a Dockerfile which uses alpine image as the base image.
Below are the steps to create & execute the docker file

1.) mvn clean package
2.) docker build -t demo/competence-server:1.0 .
3.) docker run -p 8080:8080 -t demo/competence-server:1.0

prerequisite: 
 you need to copy the skills_file.csv in the config folder. As the config folder gets copied to container , it gives us the flexibility to change the data file at the building of image.

Endpoint exposed at:

http://<<SERVER_IP_ADDR>>:8080/demo/competency

Swagger UI link:
http://<<SERVER_IP_ADDR>>:<<PORT>>/demo/swagger-ui.html

