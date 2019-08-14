# servlet annotation impl
Use servlet 3.0 annotation to implement Servlet, Servlet Filter and Servlet Listener
How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
### GET Request
- GET `localhost:8080/annotation/my/abc123` endpoint
- response body:
``` 
	Executing my filter		Executing my servlet		Executing my filter AGAIN	
```
- Tomcat Catalina Log:
```
Executing my servlet request listener
Executing my filter
Executing my servlet
Executing my filter AGAIN
```

### Redirect
- GET `localhost:8080/annotation/redirect` endpoint
- response body:
``` 
	Executing redirect filter		Executing my servlet		Executing redirect filter AGAIN	
```

- Tomcat Catalina Log:
```
Executing my servlet request listener
Executing redirect servlet
Executing redirect filter
Executing my servlet
Executing redirect filter AGAIN
Executing redirect servlet AFTER FORWARD
```