# spring-junit
Spring Junit Demo

1. @WebMvcTest for Controller Tests
2. @InjectMocks for Service Tests
3. Using Spring Rest Docs with JUNIT

## Built With

* 	[Gradle](https://gradle.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## To-Do

- [ ] Logger (Console, File, Mail)
- [x] RESTful Web Service (CRUD)


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.bhagyashree.junit.demo.Application` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing build.gradle
- Open Eclipse 
   - File -> Import -> Existing Gradle Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

### Application URL

To test application

|  URL 																				|  Method |
|-----------------------------------------------------------------------------------|---------|
|`http://localhost:8080/junit-demo`  													| GET |
|`http://localhost:8080/junit-demo/greeting/hello`     									| GET |
|`http://localhost:8080/junit-demo/persons/youngest`      								| GET |

### Actuator

To monitor and manage application

|  URL |  Method |
|----------|--------------|
|`http://localhost:8080/junit-demo`  						| GET |
|`http://localhost:8080/junit-demo/actuator/`             | GET |
|`http://localhost:8080/junit-demo/actuator/health`    	| GET |
|`http://localhost:8080/junit-demo/actuator/info`      	| GET |


## Documentation

* [Swagger](http://localhost:8080/junit-demo/swagger-ui.html) - `http://localhost:8080/junit-demo/swagger-ui.html`- Documentation & Testing


## packages

- `model` - to hold our entities;
- `repository`- to communicate with the database;
- `resources/` - Contains all the static resources, templates and property files.
- `resources/static` - contains static resources such as css, js and images.
- `resources/templates` - contains server-side templates which are rendered by Spring.
- `resources/application.yml` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server's default port, server's context path, database URLs etc, in this file.
- `test/` - contains unit and integration tests
- `build.gradle` - contains all the project dependencies