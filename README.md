# Spring Boot Project Initial

This project is a starter template for a Spring Boot application with the following features:

- **Spring Web**: For building RESTful web applications.
- **Spring Data JPA**: For database access using Java Persistence API.
- **H2 Database**: In-memory database for development and testing.
- **Lombok**: Reduces boilerplate code with annotations.
- **Hibernate**: ORM framework for data persistence.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven or Gradle

### Running the Application

1. Clone the repository.
2. Build the project:
    - With Maven: `mvn clean install`
    - With Gradle: `./gradlew build`
3. Run the application:
    - With Maven: `mvn spring-boot:run`
    - With Gradle: `./gradlew bootRun`

The application will start on [http://localhost:8080](http://localhost:8080).

### H2 Database Console

Access the H2 console at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: (leave blank)

## Project Structure

- `src/main/java` - Application source code
- `src/main/resources` - Configuration files

## Dependencies

- spring-boot-starter-web
- spring-boot-starter-data-jpa
- h2
- lombok
- hibernate-core

# for creation this project the it will follow next steps of way general: 
 - generate project new -> spring started project
	 - type maven 
	 - dependencies: 
	  	* spruing web
	  	* spring Data JPA
	  	* H2 Dtabase
	  	* lombok
  - see file dependencies in file pom.xml make sure  web, jpa, h2, lombook
 - configuration of application.propities: H2, jpa, console h2
 - create entity
 - create repository
 - create service
 - create controller
 
 # commands basic stop port 8080: 
   -  lsof -i :8080 --> watch ports in used 
    - kill -9 <PID> --> kill process  in port 

<img width="808" height="615" alt="struct folder" src="https://github.com/user-attachments/assets/2511c0e1-82c3-42ec-b0d4-df92a5e42717" />
             # Clase principal con @SpringBootApplicatio


## License

This project is licensed under the MIT License.

