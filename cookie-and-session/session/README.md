# session
How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
### Session creation and get
#### GET `localhost:8080/session/createusername=myname` endpoint
- request header:
```
no JSESSIONID
```
- response header:
```
Content-Length →38
Date →Thu, 12 Apr 2018 21:20:03 GMT
Set-Cookie →JSESSIONID=057ECEAA14CBAAA6D271B6861C8AC13D; Path=/; HttpOnly
```
- response body:
```
caller is : test, username is : myuser
```

#### GET `localhost:8080//session/get` endpoint
- response body:
```
caller is : test, username is : null
```

### Disable cookie
suppose already do the above session creation step
#### GET `localhost:8080/session/create?username=myuser` multiple times
Every time get different JSESSIONID in response header

#### GET `localhost:8080/session/get`
- response body:
```
attribute username is : null
session username is : null
Session implementation class is, null
```

#### GET `localhost:8080/session/get;jsessionid=E33D73BFB15E9F20BDB73C887C2035E2`
- response body:
```
attribute username is : null
session username is : myuser_session
Session implementation class is, class org.apache.catalina.session.StandardSessionFacade
```

### Session invalidate
#### GET `localhost:8080/session/create?username=myuser`
- response header:
```
Set-Cookie →JSESSIONID=225D406674FA630D3376ADF7B66B011D; Path=/; HttpOnly
Content-Length →20
Date →Wed, 14 Aug 2019 18:35:22 GMT
```
- response body:
```
username is : myuser
```
#### GET `localhost:8080/session/invalidate`
Nothing happen

#### GET `localhost:8080/session/invalidate;jsessionid=225D406674FA630D3376ADF7B66B011D`
- response body:
```
Name before invalidate is : myuser_session
```

### Session Redirect
#### GET `localhost:8080/session/redirect?username=myuser`
- 302 GET then 200 GET, will be redirect to `localhost:8080/session/get`
- response body
```
attribute username is : null
session username is : myuser_session
Session implementation class is, class org.apache.catalina.session.StandardSessionFacade
```

#### Session redirect when cookie is disabled
- Disable cookie
- GET `localhost:8080/session/redirect?username=myuser`
- 302 GET then 200 GET, will be redirect to `localhost:8080/session/get;jsessionid=CAD2C35C94FE30552191248320392540`
- response body:
```
attribute username is : null
session username is : myuser_session
Session implementation class is, class org.apache.catalina.session.StandardSessionFacade
```
