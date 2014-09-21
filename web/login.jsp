<%-- 
    Document   : index
    Created on : Sep 7, 2014, 11:56:51 PM
    Author     : Tommy
--%>
<%
    String errorMsg = request.getParameter("errorMsg");

// if this page is not forwarded, errorMsg would be null, we set it to an empty
// String to prevent displaying null
    if (errorMsg == null) {
        errorMsg = "";
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SMU Location Analytics Service</title>
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <link rel="shortcut icon" href="Images/globe.ico" />
    </head>

    <body>
        <a href="login.jsp" title="SLOCA System" id = "logo"></a>

        <div id ="header">
            <p>Login Page</p>
        </div>

        <div id="page">
            <form name="login_form" action="authenticate.jsp" method="post">
                <table align="center">
                    <tr>
                        <td><h1>Username: </h1></td>
                        <td><input type="text" name="username" required></input></td>
                    </tr>
                    <tr>
                        <td><h1>Password: </h1></td>
                        <td><input type="password" name="password" required></input></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="Submit" value="Submit" /></td>
                    </tr>    
                </table>
                <%=errorMsg%>
            </form>
        </div>
        <div id ="footer">Copyright@SMU SE Team G2T1 2014</div>
    </body>
</html>