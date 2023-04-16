# student-result-management-system
Student Result Management System

PreRequisites:
1. Java 11
2. My SQL Database (For Windows: https://dev.mysql.com/downloads/file/?id=516926)

Steps to Run:
1. Clone/Download the project to an IDE.
2. Configure JAVA_HOME to point to JDK 11.
3. It is a springBoot applicaton, so Tomcat is the default server to run the app.
4. Download MYSQL database and complete the configuration.
5. In aplication.properties file in location <project-directory>/src/main/resources/application.properties -> Please provide the MYSQL database user credentails in these two fields -> 
	spring.datasource.username=<username>
	spring.datasource.password=<password>
6. Launch MQSQL client and create database "student_result_management_system"
	CREATE DATABASE student_result_management_system;
	To see, if database is created run 
		SHOW DATABASES;
7. Provide the datasource URL in the aplication.properties file as
	spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:<port>/student_result_management_system
8. First time deployment of application, tables must be created so set this property in aplication.properties as
	spring.jpa.hibernate.ddl-auto=create
	Later you can modify it to none/update accordingly
	
Technologies used:
Spring Boot - Server-side
Thymeleaf - HTML5/XHTML/XML template engine
BootStrap - For CSS styling
CSS Holy Grail  - Header/Navigation/Main Body/Footer Grid Layout
MYSQL - Database

Scope for Improvement:
1. Project is using Thymleaf which is a Model View Controller framework, we can use better/advanced front-end technologies for better routing purposes.
2. For displaying results in table format, we can use Pagination to handle large amounts of data.
3. Advanced/Better UI CSS styling can be used.


