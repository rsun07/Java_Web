# Async servlet
How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
### Thread unblock scenario
- GET `localhost:8080/async/thread/unblock`
- response body:
``` 
Main Thread start!
Main Thread completed!
```
- Tomcat Catalina Log:
```
Main Thread start!
Main Thread completed!
Background Thread start!
i = 0
i = 1
i = 2
Background Thread completed!
```

### Thread wait scenario
- GET `localhost:8080/async/thread/wait`
- browser will be blocked while calculating
- response body:
``` 
Main Thread start!
Background Thread start!
sum = 3
Background Thread completed!
Main Thread completed!
```
- Tomcat Catalina Log:
```
Main Thread start!
Background Thread start!
i = 0
i = 1
i = 2
Background Thread completed!
Main Thread completed!
```

### Context Complete scenario
- GET `localhost:8080/async/context/complete`
- browser will be blocked while calculating
- response body:
``` 
Main Thread start!
Main Thread completed!
Background Thread start!
sum = 3
Background Thread completed!
```
- Tomcat Catalina Log:
```
Main Thread start!
Main Thread completed!
Background Thread start!
i = 0
i = 1
i = 2
Background Thread completed!
servlet request destroy
after async context complete, won't show up in response
```
- compare with [Thread wait scenario], `Main thread` completed before `Background thread` start

### Context Timeout scenario
- GET `localhost:8080/async/context/timeout`
- browser will be blocked while calculating
- response body:
``` 
Main Thread start!
Main Thread completed!
Background Thread start!
```
- Tomcat Catalina Log:
```
Main Thread start!
Main Thread completed!
Background Thread start!
i = 0
i = 1
i = 2
Background Thread completed!
servlet request destroy
```
- refresh the page
- response body:
``` 
sum = 3
Background Thread completed!
Main Thread start!
Main Thread completed!
Background Thread start!
```
- Tomcat Catalina Log:
``` 
Main Thread start!
Main Thread completed!
Background Thread start!
i = 0
i = 1
i = 2
servlet request destroy
Background Thread completed!
```
- It has the result from the previous response that write into the response output Stream but haven't show up before last main thread completed

### Context Dispatch scenario
- GET `localhost:8080/async/context/dispatch`
- Similar to async context complete
- browser will be blocked while calculating
- response body:
``` 
Main Thread start! Main Thread completed! Background Thread start! sum = 3 Background Thread completed! Dispatch page
```
- Tomcat Catalina Log:
```
Main Thread start!
Main Thread completed!
Background Thread start!
i = 0
i = 1
i = 2
Background Thread completed!
servlet request destroy
after async context complete, won't show up in response
```

### Context async using session to store value
- GET `localhost:8080/async/context/async`
- browser will be blocked while calculating
- GET `localhost:8080/async/context/async/result`
- response body:
``` 
Main Thread start!
Main Thread completed!
Successfully get Result
sum = 3
```
- Tomcat Catalina Log:
```
Main Thread start!
Main Thread completed!
Background Thread start!
i = 0
Result servlet, trying to get from session!
Result servlet, fail to get sum
i = 1
Result servlet, trying to get from session!
Result servlet, fail to get sum
i = 2
Result servlet, trying to get from session!
Result servlet, fail to get sum
Background Thread completed!
Result servlet, trying to get from session!
Successfully get Result
servlet request destroy
```

