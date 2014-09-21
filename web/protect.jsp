<%-- 
    Document   : protect
    Created on : Sep 7, 2014, 11:39:43 PM
    Author     : Tommy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String _userName = (String) session.getAttribute("authenticated.user");
    boolean isAuthenticated;
    
    if (_userName != null) {
        isAuthenticated = true;
    }

    
    if (_userName == null) {
        isAuthenticated = false;
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    </body>
</html>
