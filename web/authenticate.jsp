<%-- 
    Document   : authenticate
    Created on : Sep 7, 2014, 10:23:40 PM
    Author     : Tommy
--%>

<%@ page import="java.util.*" %>
<%@ page import="dao.*" %>
<%@ page import="entity.*" %>
<%

    // initial declarations
    String userName = request.getParameter("username");
    String passWord = request.getParameter("password");
    User currentUser;
    
    

    if (passWord != null) {
        
        UserDAO dao = new UserDAO();
        currentUser = (User) dao.retrieveUser(userName);
        //out.println(currentUser);
        
        if ((currentUser != null) && (currentUser.authenticate(passWord))) {
            // display authenticated info 
            session.setAttribute("authenticated.user", currentUser.getEmail());
            System.out.println();
            response.sendRedirect("bootstrap.jsp");
        } else {
            // inform user to re-enter
%>
<jsp:forward page="login.jsp">
    <jsp:param name="errorMsg" value="Invalid username/password" />
</jsp:forward>
<%    }
    }
%>