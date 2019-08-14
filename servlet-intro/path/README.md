# servlet-path

How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
- hit `localhost:8080/path/fullpath` endpoint, Tomcat Catalina Log:
```
Full Path Servlet
```
- hit `localhost:8080/path/star/abc` endpoint, Tomcat Catalina Log:
```
Path Mapping with star Servlet
```
- hit `http://localhost:8080/path/star/88.jpg` endpoint, Tomcat Catalina Log:
```
Path Mapping with star Servlet
```
- hit `http://localhost:8080/path/star/88.jsp` endpoint, Tomcat Catalina Log:
```
Path Mapping with star Servlet
```
