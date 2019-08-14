# servlet-implementation
Implementation of Servlet, to show how to accept query parameters.
Also shows two different ways of Forward (forward and include) and Redirect.
How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
### Parameters
- GET `localhost:8080/httpservlet/params?name=ryan,mike,aaa&age=23` , both Http response and Tomcat Catalina Log:
```
getParameter("name") is ryan,mike,aaa
getParameterValues("name")[0] is ryan,mike,aaa
name values is : [ryan,mike,aaa]
age is : 23
```

### Forward
#### forward
- GET `localhost:8080/httpservlet/forward/forwardserver` , both Http response and Tomcat Catalina Log:
```
Executing Forward Forward Receiptor.
The attribute is, [MyAttribute] 
The request implementation is, [class org.apache.catalina.core.ApplicationHttpRequest] 
The response implementation is, [class org.apache.catalina.connector.ResponseFacade] 
```
#### include
- GET `localhost:8080/httpservlet/forward/includeserver` , both Http response and Tomcat Catalina Log:
```
Before Include Server forward Executing forward Include Receiptor.
The attribute is, [MyAttribute]
The request implementation is, [class org.apache.catalina.core.ApplicationHttpRequest]
The response implementation is, [class org.apache.catalina.core.ApplicationHttpResponse]
After Include Server forward
```

### Redirect
- GET `localhost:8080/httpservlet/redirect/redirectserver` , will be redirected to `localhost:8080/httpservlet/redirect/redirectreceiptor`. <br>
Then both Http response and Tomcat Catalina Log:
```
Executing Redirect Receiptor.
The attribute is, [null]
The request implementation is, [class org.apache.catalina.connector.RequestFacade]
The response implementation is, [class org.apache.catalina.connector.ResponseFacade]
```