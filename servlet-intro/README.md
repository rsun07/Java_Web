# Servlet Introduction
Using the following 4 modules to get familiar with Java Servlet.
- helloworld
- servlet-config-and-context
- servlet-lifecycle
- path

Each module's read me file will have detail description and expected result.

### How to run it
#### Command line
- Using maven or jar command to pack a war package
```
$ mvn clean package
or
$ jar -cvf {war_name}.war *
```

- Move the .war file into tomcat's /webapps directory
- start tomcat 
```
$ ./startup.sh
```

#### Run in IDE (IntelliJ)
- Must be IntelliJ Ultimate version, the Community version doesn't support Java EE
- At `Run/Debug Configurations` create a new `local` tomcat server
- Set URL, `http://localhost:8080/` by default and port `8080` by default
- Switch to `Deployment` menu, add the .war file under `deploy at the server startup`
- Save and run


### View expected result
- commandline ```curl localhost:8080```
- go to browser or http client tool and call GET ```localhost:8080```
