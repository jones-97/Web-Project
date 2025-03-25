<%-- 
    Document   : updateAccount
    Created on : 20 Feb 2021, 15:26:11
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Settings</title>
    </head>
    <body>
        <h1>Profile Editing</h1>
        Update your account to get the most out of it.

        <form action="updateUser" method="post">
            
            <input type="hidden" name="hiddenEmail" value="<%= session.getAttribute("Email") %>" />
            
            
            <table style="margin-left: auto; margin-right: auto;">
                <tr>
                    <td> Email address: </td>
                    <td><label><%= session.getAttribute("Email")%></label>
                        
                </tr>
                <tr>
                    <td> First Name: </td>
                    <td><input type="text" name="firstName"> <br> </td>
                </tr>
                <table style="margin-left: auto; margin-right: auto;">
                    <tr>
                        <td> Last Name: </td>
                        <td><input type="text" name="lastName"> </td>
                    </tr>
                    <tr>
                        <td> Date of birth: </td>
                        <td><input type="date" name="dob"> <br> </td>
                    </tr>
                    <tr>
                        <td> Phone Number: </td>
                        <td><input type="number" name="phoneNumber"> </td>
                    </tr>
                    <tr>
                        <td> Address: </td>
                        <td><input type="text" name="address"> <br> </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Update Account"></td>
                    </tr>
                </table>
        </form>
    </body>
</html>
