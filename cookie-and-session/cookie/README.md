# cookie
How to run it, see [servlet-intro-readme](https://github.com/rsun07/Java_Web/tree/master/servlet-intro#how-to-run-it)

## Expected Behavior
#### GET `localhost:8080/cookie` endpoint
- request header:
```
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
Accept-Encoding: gzip, deflate, br
Accept-Language: en-US,en;q=0.9
Cache-Control: max-age=0
Connection: keep-alive
Host: localhost:8080
Upgrade-Insecure-Requests: 1
```
- response header:
```
Content-Length: 0
Date: Thu, 12 Apr 2018 20:13:08 GMT
Set-Cookie: root=root_cookie
Set-Cookie: path=path_cookie; Path=/cookie/cookiepath
Set-Cookie: version=version_cookie
Set-Cookie: ttl=ttl_cookie; Max-Age=10; Expires=Thu, 12-Apr-2018 20:13:18 GMT
```

#### GET `localhost:8080/cookie` endpoint again
- request header:
```
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
Accept-Encoding: gzip, deflate, br
Accept-Language: en-US,en;q=0.9
Cache-Control: max-age=0
Connection: keep-alive
Cookie: root=root_cookie; version=version_cookie
Host: localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko)
```
- response header:
```
Content-Length: 0
Date: Thu, 12 Apr 2018 20:37:11 GMT
Set-Cookie: root=root_cookie
Set-Cookie: path=path_cookie; Path=/cookie/cookiepath
Set-Cookie: version=version_cookie
Set-Cookie: ttl=ttl_cookie; Max-Age=10; Expires=Thu, 12-Apr-2018 20:37:21 GMT
```

#### GET `localhost:8080/cookie/get` endpoint before cookie expires (within 10 seconds)
- request header:
```
Connection: keep-alive
Cookie: root=root_cookie; version=version_cookie; ttl=ttl_cookie
Host: localhost:8080
Upgrade-Insecure-Requests: 1
```
- response header:
```
root = root_cookie version: 0
version = version_cookie version: 0
ttl = ttl_cookie version: 0
```

#### GET `localhost:8080/cookie/get` endpoint after cookie expired (after 10 seconds)
- request header:
```
Connection: keep-alive
Cookie: root=root_cookie; version=version_cookie
Host: localhost:8080
Upgrade-Insecure-Requests: 1
```
- response header:
```
root = root_cookie version: 0
version = version_cookie version: 0
```

#### GET `localhost:8080/cookie/cookiepath` endpoint after cookie expired (after 10 seconds)
- Tomcat Localhost log:
```
path = path_cookie version: 0
version = version_cookie version: 0
root = root_cookie version: 0
version = version_cookie version: 0

```