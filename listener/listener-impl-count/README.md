# listener-impl-count
Servlet listener (Http Sesion Listener) practice. Implement request counter using http session listener

How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
- hit `localhost:8080` endpoint, Tomcat Catalina Log:
```
Totally number 1 request
Current visiting client number is : 1
```
- refresh `localhost:8080` endpoint 9 times, Tomcat Catalina Log:
```
Totally number 10 request
Current visiting client number is : 1
```
- hit `127.0.0.1:8080` endpoint, Tomcat Catalina Log:
```
Totally number 11 request
Current visiting client number is : 2
```
- hit local ip `192.168.0.102:8080` endpoint again, Tomcat Catalina Log:
```
Totally number 12 request
Current visiting client number is : 3
```
- wait 1 minute for each http session to be expired, Tomcat Catalina Log:
```
Current visiting client number is : 2

Current visiting client number is : 1

Current visiting client number is : 0
```
