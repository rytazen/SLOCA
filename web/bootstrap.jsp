<%-- 
    Document   : bootstrap
    Created on : Sep 8, 2014, 1:31:15 AM
    Author     : Tommy
--%>
<%@page import="java.text.*"%>
<%@include file="protect.jsp" %>
<%@page import = "java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%        String userName = (String) session.getAttribute("authenticated.user");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        
            //out.println("Hello " + userName + "</br>");
            
            Date currentDate = new Date();
            String formatDate = df.format(currentDate);
            out.println("Today's date is "+ formatDate + "</br>");
        

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SMU Location Analytics Service</title>
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <link rel="shortcut icon" href="Images/globe.ico" />
    </head>

    <body>
        <a href="index.jsp" title="SLOCA System" id = "logo"></a>
        <div id ="header">
            <p>Administrative Page</p>
            <p>You are currently logged in as: <%=userName%></p>
        </div>

        <div id="sidebar">
            <div id="menu">
                <ul>
                    <li><a href="#">View Heatmap</a></li>
                    <li><a href="#">View Reports</a></li>
                    <li><a href="logout.jsp">Logout</a><li>
                </ul>
            </div>
        </div>

        <div id="page">
            <form name="login_form" action="authenticate.jsp" method="post">
                <table align="center">
                    <tr>
                        <td><h1>Select File to bootstrap: </h1></td>
                        <td><input type="text" name="username" required></input></td>
                        <td><input type="submit" name="Upload" value="Upload" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="Submit" value="Submit" /></td>
                    </tr>
                </table>
        </div>
        <div id ="footer">Copyright@SMU SE Team G2T1 2014</div>
    </body>
</html>