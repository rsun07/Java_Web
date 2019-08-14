# servlet dynamic register
Dynamically register servlets, listeners.</br>

How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
### GET  `localhost:8080/dynamic/myservlet` endpoint, Tomcat Catalina log:
``` 
Executing My Request Listener
Executing context listener
Executing My Filter for URL Pattern
Executing My Filter for servlet
Successfully register servlet!
This: Init param, Key: namespace; Value: dynamic_namespace
Executing My Filter for servlet
Executing My Filter for URL Pattern
```

### GET  `localhost:8080/dynamic/myservletwithconfig` endpoint, Tomcat Catalina log:
``` 
Executing My Request Listener
Successfully register servlet!
With Config: Init param, Key: key; Value: value
With Config: Init param, Key: inti_params; Value: inti_params
```
