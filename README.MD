First Spring boot web application

Compile
```
mvn clean package spring-boot:repackage
```

Run from the target directory
```
java -jar first-spring-rest-project-1.0-SNAPSHOT.jar
```

Endpoints
@GET http://localhost:8080/foo/config
@PUT http://localhost:8080/foo/name/{string}
@PUT http://localhost:8080/foo/id/{id}