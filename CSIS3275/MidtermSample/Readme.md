Project the professor provided to study for the midterm.

Dependencies:

- Spring Boot DevTools
- Lombok
- Spring Data JPA
- H2 Database
- Spring Web
- Rest Repositories HAL Explorer


application.properties file:

spring.application.name=midtermSample
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

