# virtual-power-plant
Spring Boot 2.6.6
Java version 1.8
Database: postgreSQL
create database vpp_db.

API:
For create:
http://localhost:8080/batteries
 For List:
 http://localhost:8080/batteries?postcode=6000
 - provide postcode range in param
 - if you provide 6000 postcode range then return list less than and equal of 6000 and sorted alphabetically with name. .
  
  Tested API using Postman
