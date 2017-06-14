# Homework1

## Maven and Java required

## start the MySQL Docker

open a terminal, go to the project folder with docker-compose.yml. run
```bash
docker-compose up -d
```

## Run Spring Application

open a new terminal, and go to the project folder, run
```bash
mvn clean install
```

start the server by run
```bash
java -jar ./target/ruuning-Information-Analysis-Service-1.0.0-SNAPSHOT.jar
```

##Insert

send POST to "http://localhost:8080/running_info"
and the request should be send by JSON and form should similar to:
```json
[
 {
  "runningId": "7c08973d-bed4-4cbd-9c28-9282a02a6032",
  "latitude": "38.9093216",
  "longitude": "-77.0036435",
  "runningDistance": "39492",
  "totalRunningTime": "2139.25",
  "heartRate": 0,
  "timestamp": "2017-04-01T18:50:35Z",
  "userInfo": {
  "username": "ross0",
  "address": "504 CS Street, Mountain View, CA 88888"
  }
 }
]
```
for delete a specified ID data, send request to "http://localhost:8080/running_information/{ID} 
