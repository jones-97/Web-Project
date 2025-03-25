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
        <title>Registration Page</title>
    </head>

    <body>
        <h1 style="text-align: center" >Fill in an email address to register. </h1>

        <form action="register" method="post">
            <table style="margin-left: auto; margin-right: auto;">
                <tr>
                    <td> Email address: </td>
                    <td><input type="email" name="emailAddress"> </td>
                </tr>
                <tr style="display:none"> 
                    <td><!-- Password here, but hidden --></td> </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Register" > </td>
                </tr>
            </table> 
        </form>
        
        <p style="text-align: center"> Once you fill in your email address, 
            a link will be sent with your login details. </p>
    </body>

</html>
