<%--
  Created by IntelliJ IDEA.
  User: VINH
  Date: 12/7/2023
  Time: 7:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        if(session.getAttribute("username") == null){
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>
