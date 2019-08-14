# Servlet lifecycle
How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
- Tomcat start up, will see this from Tomcat Catalina Log:
```
Connected to server
[2018-04-10 10:53:28,899] Artifact servlet-lifecycle:war: Artifact is being deployed, please wait...
Create Servlet 1
Init Servlet 1
Create Servlet 2
Init Servlet 2
[2018-04-10 10:53:29,377] Artifact servlet-lifecycle:war: Artifact is deployed successfully
[2018-04-10 10:53:29,377] Artifact servlet-lifecycle:war: Deploy took 478 milliseconds
```
- GET `/lifecycle0`  (servlet0 is set to lazy load)
```
Create Servlet 0
Init Servlet 0
Executing Servlet 0
```
- GET `/lifecycle0`  again
```
Executing Servlet 0
```
- GET `/lifecycle1`  multiple times
```
Executing Servlet 1
Executing Servlet 1
Executing Servlet 1
...
```
- GET `/lifecycle2`  multiple times
```
Executing Servlet 2
Executing Servlet 2
Executing Servlet 2
...
```

- stop the server
```
Destroying Servlet 1
Destroying Servlet 2
Destroying Servlet 0
Disconnected from server
The servlet with high priority will be initialed earlier and destroyed earlier too
```
