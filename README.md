# Meeting
API Rest returns free user schedule, validate with JWT each request, you have to send a date to check user available that day.

#Input
Is a Get function, you can access at:
`http://localhost:8080/meeting/available?date=2019-06-10`

#Output
```[
      {
      "time": "8:00",
      "users":       [
                  {
            "id": 1,
            "name": "Name",
            "lastname": "Lastname"
         }
      ]
   }...
   ]
   ```


# Resources
* Java 8
* IntelliJ IDEA Ultimate 2018.2
* Maven 4.0.0
* Spring Boot 2.1.5
* PostgresSQL  9.5

# Install
* Create a BDD name: meeting 
* Import SQL script from folder: /src/main/resources/database
* Add project to IntelliJ
* Run as SpringBoot Application
