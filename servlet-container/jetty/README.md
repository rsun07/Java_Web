# jetty

A simple web service including Servlet, Filter, Session Listener and Context Listener implement with Jetty.

## How to run it
### IDE
- run JettyServer class main method

### command line
- Using maven or command line tool pack the whole package into a jar file
- run the main method under JettyServer class

## Expected Behavior
### Jetty starts
``` 
2019-08-14 13:37:40.844:INFO::main: Logging initialized @164ms to org.eclipse.jetty.util.log.StdErrLog
2019-08-14 13:37:40.951:INFO:oejs.Server:main: jetty-9.4.6.v20170531
Context class in Context Listener : class org.eclipse.jetty.servlet.ServletContextHandler$Context
FilterConfig Class in Filter : class org.eclipse.jetty.servlet.FilterHolder$Config
2019-08-14 13:37:41.058:INFO:oejsh.ContextHandler:main: Started o.e.j.s.ServletContextHandler@17d99928{/jetty,null,AVAILABLE}
2019-08-14 13:37:41.090:INFO:oejs.AbstractConnector:main: Started ServerConnector@45c8e616{HTTP/1.1,[http/1.1]}{0.0.0.0:9090}
2019-08-14 13:37:41.091:INFO:oejs.Server:main: Started @414ms
```
### GET `localhost:8080/jetty/myservlet` , JettyServer log:
``` 
Request Class in Filter : class org.eclipse.jetty.server.Request
Response Class in Filter : class org.eclipse.jetty.server.Response
FilterChain Class in Filter : class org.eclipse.jetty.servlet.ServletHandler$CachedChain
Request Class in Servlet : class org.eclipse.jetty.server.Request
Response Class in Servlet : class org.eclipse.jetty.server.Response
```

