<%--
  Created by IntelliJ IDEA.
  User: scotg_000
  Date: 2015/7/19
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0 user-scalable=no">
<link href="css/login.css" rel="stylesheet" type="text/css">
<head>
    <title>后台登陆</title>
</head>
<body>

<!-- Header -->
<header id="header">
    <h1>光电团学联 服务器后台登陆</h1>

    <p>请在下方输入密码<br/>
        以获得权限.</p>
</header>

<!-- Signup Form -->
<form id="signup-form" method="post" action="${pageContext.request.contextPath}/Admin.jsp">
    <input type="password" name="entryCode" id="email" placeholder="密码"/>
    <input type="submit" value="登陆"/>
</form>
<!--[if lte IE 8]>
<script src="js/ie/respond.min.js"></script><![endif]-->
<script src="js/login.js"></script>

</body>
</html>
