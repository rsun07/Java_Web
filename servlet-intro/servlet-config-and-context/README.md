# servlet-config-and-context

How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
- GET `localhost:8080/servlet1` endpoint, Tomcat Catalina Log:
```
Create Servlet 1
Init Servlet 1
Executing Servlet 1

Init Parameter key is [address], value is [servlet1-java-web]

Init Parameter key is [namespace], value is [servlet1-config]

 context path is: 

 real path for /config_and_context.html is: /Users/xiaoming.sun/Courses/Java_Web/servlet-intro/servlet-config-and-context/target/servlet-config-and-context/config_and_context.html
Servlet 1 : Context namespace is: all servlet shared context param
Servlet 1 : Context Attribute email is: null
```
- GET `localhost:8080/servlet1` endpoint again, Tomcat Catalina Log:
```
Executing Servlet 1

Init Parameter key is [address], value is [servlet1-java-web]

Init Parameter key is [namespace], value is [servlet1-config]

 context path is: 

 real path for /config_and_context.html is: /Users/xiaoming.sun/Courses/Java_Web/servlet-intro/servlet-config-and-context/target/servlet-config-and-context/config_and_context.html
Servlet 1 : Context namespace is: all servlet shared context param
Servlet 1 : Context Attribute email is: myeamil@email.com
```
- GET `localhost:8080/servlet2` endpoint, Tomcat Catalina Log:
```
Create Servlet 2
Init Servlet 2
Executing Servlet 2

Init Parameter key is [address], value is [servlet2-java-web]

Init Parameter key is [namespace], value is [servlet2-config]
Servlet 2 : Context Attribute namespace is: all servlet shared context param
Servlet 2 : Context Attribute email is: myeamil@email.com
Servlet 2 remove Attribute email
```
- GET `localhost:8080/servlet2` endpoint again, Tomcat Catalina Log:
```
Executing Servlet 2

Init Parameter key is [address], value is [servlet2-java-web]

Init Parameter key is [namespace], value is [servlet2-config]
Servlet 2 : Context Attribute namespace is: all servlet shared context param
Servlet 2 : Context Attribute email is: null
Servlet 2 remove Attribute email
```
- GET `localhost:8080/servlet1` endpoint again, Tomcat Catalina Log:
```
Executing Servlet 1

Init Parameter key is [address], value is [servlet1-java-web]

Init Parameter key is [namespace], value is [servlet1-config]

 context path is: 

 real path for /config_and_context.html is: /Users/xiaoming.sun/Courses/Java_Web/servlet-intro/servlet-config-and-context/target/servlet-config-and-context/config_and_context.html
Servlet 1 : Context namespace is: all servlet shared context param
Servlet 1 : Context Attribute email is: null
```
