## SCSB-Config-Server

   SCSB Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server, you have a central place to manage external properties for applications across all environments.
   
### Software Required
          - Java 11
          - Docker 19.03.13      
          
### Prerequisite
1. external-application_config_server.properties

  **This file contins the Database connection property for Config Server and should be placed under <config folder>**

 spring.datasource.url=XXXXXX

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.datasource.username=XXXXXX (Encrypted Value)

spring.datasource.password=XXXXXX (Encrypted Value)

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

2. config-server-key.properties

**This file contins Secret key used for Encryption logic and should be placed under <config folder>**

scsb.encryption.secretkey=XXXXXX


### Build
   Download the Project , navigate inside project folder and  build the project using below command
  
   **./gradlew clean build -x test**

### Docker Image Creation
   Naviagte Inside project folder where Dockerfile is present and Execute the below command

 **sudo docker build -t scsb-config-server  .**

### Docker Run

User the below command to Run the Docker 
 
sudo docker run --name scsb-config-server -v <volume>  -p <port>:<port>  --label collect_logs_with_filebeat="true" --label decode_log_event_to_json_object="true" -e "ENV= -Dspring.config.location=/recap-vol/config/external-application_config_server.properties  -Dspring.config.additional-location=/recap-vol/keys/config-server-key.properties -Dserver.port=<port>" --network=scsb   -d scsb-config-server


### Accessing Values from Config Server

 With your config server running, you can make HTTP requests to the server to retrieve values from the  backend.Use the below URL to get the values.
 
 http://localhost:<port>/application/default
 
 To Get the Profile Specific Values use the below URL.
 
 Replace PROFILENAME -- with Actual Profile name i.e. DEV,QA,UAT,PROD
   
  http://localhost:<port>/application/PROFILENAME
 
