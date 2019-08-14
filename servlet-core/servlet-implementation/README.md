# servlet-implementation
Provide a implementation of javax.servlet.Servlet. To show how Java, Tomcat, Apache and etc. provided generic servlet class. <br>
How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
- GET `localhost:8080/implementation/myservlet` , Tomcat Catalina Log:
```
Initialize My Generic Servlet
Initialize My Servlet
Executing MyServlet service method!

Init param in servlet [myservlet] for namespace is : [myservlet-param]
Context param get by servlet [myservlet] for namespace is : [context-param]
```
- GET `localhost:8080/implementation/myservlet_empty_init` , Tomcat Catalina Log:
```
Initialize My Generic Servlet
Initialize MyServlet overrides empty init()!
Executing MyServlet Empty Init service method!
```
- GET `localhost:8080/implementation/javaservlet` , Tomcat Catalina Log:
```
Initialize Java Servlet overrides empty init()!
Executing Java Servlet service method!

Init param in servlet [javaservlet] for namespace is : [javaservlet-param]
Context param get by servlet [javaservlet] for namespace is : [context-param]
```
