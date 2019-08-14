# filter-lifecycle

How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
- GET `localhost:8080/filter/lifecycle` , Tomcat Catalina Log:
```
Connected to server
[2018-04-14 04:30:15,183] Artifact filter-lifecycle:war: Artifact is being deployed, please wait...
Constructing My Filter
Initialize My Filter
[2018-04-14 04:30:15,564] Artifact filter-lifecycle:war: Artifact is deployed successfully
[2018-04-14 04:30:15,564] Artifact filter-lifecycle:war: Deploy took 381 milliseconds

Do Filter before filter chain
Do MyServlet Filter before filter chain
Running doGet() in MyServlet
Do MyServlet Filter after filter chain
Do Filter after filter chain

Do Filter before filter chain
Do MyServlet Filter before filter chain
Running doGet() in MyServlet
Do MyServlet Filter after filter chain
Do Filter after filter chain

Do Filter before filter chain
Do MyServlet Filter before filter chain
Running doGet() in MyServlet
Do MyServlet Filter after filter chain
Do Filter after filter chain

14-Apr-2018 16:30:24.924 INFO [ContainerBackgroundProcessor[StandardEngine[Catalina]]] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [/Users/xiaoming.sun/Downloads/apache-tomcat-9.0.7/webapps/manager]
14-Apr-2018 16:30:24.950 INFO [ContainerBackgroundProcessor[StandardEngine[Catalina]]] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [/Users/xiaoming.sun/Downloads/apache-tomcat-9.0.7/webapps/manager] has finished in [26] ms
Do Filter before filter chain
Running doGet() in MyServlet
Do Filter after filter chain
/Users/xiaoming.sun/Downloads/apache-tomcat-9.0.7/bin/catalina.sh stop
14-Apr-2018 16:30:36.420 INFO [main] org.apache.catalina.core.StandardServer.await A valid shutdown command was received via the shutdown port. Stopping the Server instance.
14-Apr-2018 16:30:36.420 INFO [main] org.apache.coyote.AbstractProtocol.pause Pausing ProtocolHandler ["http-nio-8080"]
14-Apr-2018 16:30:36.475 INFO [main] org.apache.coyote.AbstractProtocol.pause Pausing ProtocolHandler ["ajp-nio-8009"]
14-Apr-2018 16:30:36.530 INFO [main] org.apache.catalina.core.StandardService.stopInternal Stopping service [Catalina]
Destroy My Filter
```

- GET `localhost:8080/filter/nochain` , Tomcat Catalina Log:
```
Do No Chain Filter before filter chain
Do No Chain Filter after filter chain
```
