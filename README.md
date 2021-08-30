# Micronaut Demo

Micronaut [https://docs.micronaut.io/latest/guide/index.html] is a fast starting framework for microservices and
serverless code similar to Spring Boot.

This project demonstrates creating a simple REST API that saves data in h2 with minimal code.

## Development

The `gradle.properties` contains the micronaut version.  
The `id("com.github.johnrengelman.shadow") version "7.0.0"` plugin creates the fat jar to enable running from the
application from the command line.

Create a deployable Micronaut application as an executable JAR file by running `./gradlew assemble`.

You can run the project with `./gradlew run`, however, to see the fast start time (sub-second) you should run the
executable jar.

Call the API to check the application is working

    curl -X POST "http://localhost:8080/accounts" -H  "Content-Type: application/json" -d '{"name": "John Doe", "type": "CURRENT", "age": "25"}'
    curl http://localhost:8080/accounts
