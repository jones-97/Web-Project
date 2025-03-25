<%-- 
    Document   : index
    Created on : Feb 17, 2021, 4:10:38 PM
    Author     : zurion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to our Site!</title>
    </head>

    <body>
        

        <form action="logIn" method="post">
            
            
            <p style="text-align: center">Log in to your account.</p>
            
            <table style="margin-left: auto; margin-right: auto;">
                <tr>
                    <td> Email address: </td>
                    <td><input type="email" name="emailAddress"> </td>
                </tr>
                <tr>
                    <td> Password:            </td>
                    <td><input type="password" name="password"> <br> </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Log In"> </td>
                </tr>
            </table> 
            <br><br><br><br>
        </form>
        
        
        <form action="registerPage.jsp">
            <p style="text-align: center"> If you don't have an account, register by clicking the button below. </p>
        
            <div style="text-align: center">
            <input type='submit' value='Register for account'>
            </div>
        </form>
    </body>

</html>
