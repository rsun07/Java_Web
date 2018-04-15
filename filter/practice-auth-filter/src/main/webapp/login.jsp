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
    <title>Log in</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        User Name : <input type="text" name="username"/> <br>
        Password : <input type="password" password="password"/> <br>
        <input type="submit" value="Log In">
    </form>
</body>
</html>
