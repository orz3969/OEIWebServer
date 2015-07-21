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
    <title>ManagementLogin</title>
</head>
<body>

<!-- Header -->
<header id="header">
    <h1>OEINetwork Login</h1>

    <p>Get access to all application forms and works<br/>
        Start here.</p>
</header>

<!-- Signup Form -->
<form id="signup-form" method="post" action="${pageContext.request.contextPath}/Admin.jsp">
    <input type="password" name="entryCode" id="email" placeholder="Enter the password"/>
    <input type="submit" value="Login"/>
</form>
<!--[if lte IE 8]>
<script src="js/ie/respond.min.js"></script><![endif]-->
<script src="js/login.js"></script>

</body>
</html>
