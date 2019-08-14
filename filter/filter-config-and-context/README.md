# filter-config-and-context

How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
- GET `localhost:8080/filter/config` endpoint, Tomcat Catalina Log:
```
Running Filter:
Context Init param, namespace : context-namespace
Filter Init Param, name is namespace, value is filter-namespace


Running Servlet:
Context Init param, namespace : context-namespace
Filter context attribute, servlet_attr : context_filter_attr
Filter request attribute, servlet_attr : request_filter_attr


Back to Filter:
Servlet context attribute, servlet_attr : servlet_context_attr
Servlet request attribute, servlet_attr : servlet_request_attr
```
