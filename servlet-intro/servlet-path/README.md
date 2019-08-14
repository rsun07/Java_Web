# servlet-path

How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
- GET `localhost:8080/path/fullpath` , Tomcat Catalina Log:
```
Full Path Servlet
```
- GET `localhost:8080/path/star/abc` , Tomcat Catalina Log:
```
Path Mapping with star Servlet
```
- GET `http://localhost:8080/path/star/88.jpg` , Tomcat Catalina Log:
```
Path Mapping with star Servlet
```
- GET `http://localhost:8080/path/star/88.jsp` , Tomcat Catalina Log:
```
Path Mapping with star Servlet
```
