# Tomcat

A simple web service including Servlet, Filter, Session Listener and Context Listener implement with Tomcat using servlet 3.0 annotation.

## How to run it
see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
### Tomcat starts
``` 
/Users/xiaoming.sun/Downloads/apache-tomcat-9.0.7/bin/catalina.sh run
[2019-08-14 02:05:51,020] Artifact tomcat:war: Waiting for server connection to start artifact deployment...
14-Aug-2019 14:05:51.749 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server version:        Apache Tomcat/9.0.7
14-Aug-2019 14:05:51.750 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server built:          Apr 3 2018 19:53:05 UTC
14-Aug-2019 14:05:51.751 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server number:         9.0.7.0
14-Aug-2019 14:05:51.751 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log OS Name:               Mac OS X
14-Aug-2019 14:05:51.751 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log OS Version:            10.12.6
14-Aug-2019 14:05:51.751 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Architecture:          x86_64
14-Aug-2019 14:05:51.751 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Java Home:             /Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre
14-Aug-2019 14:05:51.751 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log JVM Version:           1.8.0_211-b12
14-Aug-2019 14:05:51.751 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log JVM Vendor:            Oracle Corporation
14-Aug-2019 14:05:51.751 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log CATALINA_BASE:         /Users/xiaoming.sun/Library/Caches/IntelliJIdea2019.2/tomcat/cookie_(1)_Java_Web_7
14-Aug-2019 14:05:51.751 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log CATALINA_HOME:         /Users/xiaoming.sun/Downloads/apache-tomcat-9.0.7
14-Aug-2019 14:05:51.753 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.util.logging.config.file=/Users/xiaoming.sun/Library/Caches/IntelliJIdea2019.2/tomcat/cookie_(1)_Java_Web_7/conf/logging.properties
14-Aug-2019 14:05:51.753 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
14-Aug-2019 14:05:51.753 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote=
14-Aug-2019 14:05:51.753 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote.port=1099
14-Aug-2019 14:05:51.755 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote.ssl=false
14-Aug-2019 14:05:51.755 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote.password.file=/Users/xiaoming.sun/Library/Caches/IntelliJIdea2019.2/tomcat/cookie_(1)_Java_Web_7/jmxremote.password
14-Aug-2019 14:05:51.755 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote.access.file=/Users/xiaoming.sun/Library/Caches/IntelliJIdea2019.2/tomcat/cookie_(1)_Java_Web_7/jmxremote.access
14-Aug-2019 14:05:51.755 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.rmi.server.hostname=127.0.0.1
14-Aug-2019 14:05:51.755 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djdk.tls.ephemeralDHKeySize=2048
14-Aug-2019 14:05:51.755 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.protocol.handler.pkgs=org.apache.catalina.webresources
14-Aug-2019 14:05:51.755 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dorg.apache.catalina.security.SecurityListener.UMASK=0027
14-Aug-2019 14:05:51.755 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dignore.endorsed.dirs=
14-Aug-2019 14:05:51.756 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcatalina.base=/Users/xiaoming.sun/Library/Caches/IntelliJIdea2019.2/tomcat/cookie_(1)_Java_Web_7
14-Aug-2019 14:05:51.756 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcatalina.home=/Users/xiaoming.sun/Downloads/apache-tomcat-9.0.7
14-Aug-2019 14:05:51.756 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.io.tmpdir=/Users/xiaoming.sun/Downloads/apache-tomcat-9.0.7/temp
14-Aug-2019 14:05:51.756 INFO [main] org.apache.catalina.core.AprLifecycleListener.lifecycleEvent The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [/Users/xiaoming.sun/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.]
14-Aug-2019 14:05:51.873 INFO [main] org.apache.coyote.AbstractProtocol.init Initializing ProtocolHandler ["http-nio-8080"]
14-Aug-2019 14:05:51.892 INFO [main] org.apache.tomcat.util.net.NioSelectorPool.getSharedSelector Using a shared selector for servlet write/read
14-Aug-2019 14:05:51.900 INFO [main] org.apache.coyote.AbstractProtocol.init Initializing ProtocolHandler ["ajp-nio-8009"]
14-Aug-2019 14:05:51.901 INFO [main] org.apache.tomcat.util.net.NioSelectorPool.getSharedSelector Using a shared selector for servlet write/read
14-Aug-2019 14:05:51.901 INFO [main] org.apache.catalina.startup.Catalina.load Initialization processed in 468 ms
14-Aug-2019 14:05:51.932 INFO [main] org.apache.catalina.core.StandardService.startInternal Starting service [Catalina]
14-Aug-2019 14:05:51.932 INFO [main] org.apache.catalina.core.StandardEngine.startInternal Starting Servlet Engine: Apache Tomcat/9.0.7
14-Aug-2019 14:05:51.942 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
14-Aug-2019 14:05:51.953 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["ajp-nio-8009"]
14-Aug-2019 14:05:51.956 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in 54 ms
Connected to server
[2019-08-14 02:05:52,182] Artifact tomcat:war: Artifact is being deployed, please wait...
14-Aug-2019 14:05:52.900 INFO [RMI TCP Connection(2)-127.0.0.1] org.apache.jasper.servlet.TldScanner.scanJars At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
Context class in Context Listener : class org.apache.catalina.core.ApplicationContextFacade
FilterConfig Class in Filter : class org.apache.catalina.core.ApplicationFilterConfig
[2019-08-14 02:05:52,947] Artifact tomcat:war: Artifact is deployed successfully
[2019-08-14 02:05:52,947] Artifact tomcat:war: Deploy took 765 milliseconds

```
### GET `localhost:8080/tomcat/myservlet` , JettyServer log:
``` 
Request Class in Filter : class org.apache.catalina.connector.RequestFacade
Response Class in Filter : class org.apache.catalina.connector.ResponseFacade
FilterChain Class in Filter : class org.apache.catalina.core.ApplicationFilterChain
Request Class in Servlet : class org.apache.catalina.connector.RequestFacade
Response Class in Servlet : class org.apache.catalina.connector.ResponseFacade
```

