## Task 1 - Set up the connection
### The h2 database dependency should be already in your pom.xml file 



<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>

<br>


By default, Spring Boot configures the application to connect to an in-memory store with the username sa and an empty password. This can be changed using in application.properties file which is located in the resources folder of your main folder. We are leveraging Spring Boot’s convention over configuration approach. Spring Boot would read the additional setup from the mentioned application.properties file. If the file has a different name, or is stored in a different location, the set up will fail. Here, we are enabling the h2 browser-based console and changing the password.
<br>

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
Run your Spring Boot application, open your browser and navigate to localhost:8080/h2-console .

Make sure you use the changed password and the correct datasource URL. As per the application.properties, it should be jdbc:h2:mem:testdb.
