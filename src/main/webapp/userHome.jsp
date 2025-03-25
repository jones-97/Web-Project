<%-- 
    Document   : userHome
    Created on : Feb 18, 2021, 3:30:47 PM
    Author     : zurion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page!</h1>
        
        <p> Welcome, <%=session.getAttribute("Email") %> </p>
        
        <h3>User details: </h3>
        <form action="checkUser" method="put">
            
        First name:    <label></label>
        Last name:     <label></label>
        Date of birth: <label></label>
        First name:    <label></label>
        First name:    <label></label>
        First name:    <label></label>
        
        </form>
        <a href="updateAccount.jsp">Update details </a>
        <br><br><br>
        <a href="userOnline">View registered users </a>
    </body>
</html>
