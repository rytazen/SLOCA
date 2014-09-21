<%-- 
    Document   : insertUser
    Created on : Sep 18, 2014, 11:52:43 PM
    Author     : Tommy
--%>
<%@page import="java.io.*" %>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
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
            <form name="uploadForm" method="post" enctype="multipart/form-data">
                <table align="center">
                    <tr>
                        <%
                            String saveFile = new String();
                            String contentType = request.getContentType();
                            
                            if((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)){
                                DataInputStream in = new DataInputStream(request.getInputStream());
                                
                                int formDataLength = request.getContentLength();
                                byte dataBytes[] = new byte[formDataLength];
                                int byteRead = 0;
                                int totalBytesRead = 0;
                                
                                while(totalBytesRead < formDataLength){
                                    byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
                                    totalBytesRead += byteRead;
 
                                }
                            }
                        }
                            
                        %>
                            
                        <td><h1>Select File to insert table: </h1></td>
                        <td><input type="file" name="fileToUpload" ></input></td>
                        
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
