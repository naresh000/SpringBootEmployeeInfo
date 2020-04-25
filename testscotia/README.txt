This is a spring boot application with basic authentication to use this follow below insruction.

You can use the MySQL Employee database for a sample back-end to surface some master/detail information. You can get the docker image from this repository: https://hub.docker.com/r/genschsa/mysql-employees/

Download this repo and open in IDE as maven project.

Launch the appliction and invoke these URLs one by one on POSTMAN and observe the outputs. In this demo, default page number is 0, page size is 10. You have to log in using below username and tocken.

Get Employees End point

http://localhost:8080/api/v1/employees

http://localhost:8080/api/v1/employees?pageSize=10&pageNumber=1

http://localhost:8080/api/v1/employees?pageSize=50&pageNumber=2

Get Employee by id end point

http://localhost:8080/api/v1/employees/100001
