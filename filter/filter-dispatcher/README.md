# filter-dispatcher

How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
- GET `localhost:8080/filter/forward` , both Tomcat Catalina Log:
```
Executing My Filter
Executing Forward Filter
Executing Forward Servlet
Executing Forward Receiptor
Executing Forward Filter again
Executing My Filter again
```
<br>

Http response: <br>
```	Executing My Filter		Executing Forward Filter		Executing Forward Servlet		Executing Forward Receiptor		Executing Forward Filter again		Executing My Filter again	```

- GET `localhost:8080/filter/forward` , both Tomcat Catalina Log:
```
Executing My Filter
Executing Forward Filter
Executing Forward Servlet
Executing Forward Receiptor
Executing Forward Filter again
Executing My Filter again
```
<br>

Http response: <br>
```	Executing My Filter		Executing Forward Filter		Executing Forward Servlet		Executing Forward Receiptor		Executing Forward Filter again		Executing My Filter again	```
- GET `localhost:8080/filter/include` , both Tomcat Catalina Log:
```
Executing My Filter
Executing Include Filter
Executing Include Servlet
Executing Include Receiptor
Executing Include Filter again
Executing My Filter again
```
<br>

Http response: <br>
```Executing My Filter		Executing Include Filter		Executing Include Servlet		Executing Include Receiptor		Executing Include Filter again		Executing My Filter again```

Http response: <br>
```	Executing My Filter		Executing Forward Filter		Executing Forward Servlet		Executing Forward Receiptor		Executing Forward Filter again		Executing My Filter again	```
- GET `localhost:8080/filter/redirect` , both Tomcat Catalina Log:
```
Executing My Filter
Executing Redirect Filter
Executing Redirect Servlet
Executing Redirect Filter again
Executing My Filter again
Executing My Filter
Executing Redirect Receiptor
Executing My Filter again
```
<br>

Http response: <br>
```	Executing My Filter		Executing Redirect Receiptor		Executing Forward Filter again	```