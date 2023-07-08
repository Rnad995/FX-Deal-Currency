# FX-Deal-Currency

# How to build/run it

Setup MySQL on your local environment. Create schema "Request", "Currency".       
This is a maven project built with maven.        
Project can be built using command line : mvn clean install.   
To run the application using command line : mvn spring-boot:run or 
Application is accessible at :  
- end point request page - http://localhost:8080/home


# Technology Used

Java , Spring boot , Maven , Spring boot JPA  , Spring boot thymeleaf , Postgresql, HTML/CSS/JS, JUNIT, GNU Make, Chocolaty, Apache Maven, and Docker           

# Problem Statement

ClusteredData Warehouse
Suppose you are part of a scrum team developing data warehouse for Bloomberg to analyze FX deals. One of customer stories is to accept deals details from and persist them into DB.


Request logic as following:

Request Fields(Deal Unique Id, From Currency ISO Code "Ordering Currency", To Currency ISO Code, Deal timestamp, Deal Amount in ordering currency).
Validate row structure.(e.g: Missing fields, Type format..etc. We do not expect you to cover all possible cases but we'll look to how you'll implement validations)
System should not import same request twice.
No rollback allowed, what every rows imported should be saved in DB.

Deliverables should be ready to work including:

Use Actual Db, you can select between (Postgres, MySql or MongoDB)
Workable deployment including sample file (Docker Compose).
Maven or Gradle project is required for full source code.
Proper error/exception handling.
Proper Logging.
Proper unit testing with respected Coverage.
Proper documentation using md.
Delivered over Githhub.com.
Makefile to streamline running application (plus).

# To streamline running application 
### we can use Makefile to:

-  clean  - Clean build artifacts
-  build  - Build the project
-  run    - Run the application
-  test   - Run tests
-  help   - Display this help message

### Future Work:

- using ehcache to make the performance of request faster
- deploy the project on heroku or AWS ec2
- complete convertor method in Front-end side
- Normalise database instead of using two table
- - Go deeping thorugh docker
