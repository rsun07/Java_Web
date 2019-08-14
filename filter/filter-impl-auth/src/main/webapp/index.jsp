<%--
  Created by IntelliJ IDEA.
  User: xiaoming.sun
  Date: 4/15/18
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    Index page. <br>
    Please login
    <form action=./user/welcome.jsp method="post">
        User Name : <input type="text" name="uname"/> <br>
        Password : <input type="password" name="pword"/> <br>
        <input type="submit" value="Log In">
    </form>
</body>
</html>
