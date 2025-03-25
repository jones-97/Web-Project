/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import data.UsersDB;
import java.sql.SQLException;
import model.*;
import java.util.*;
import java.util.logging.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author zurion
 */
public class regUserServlet extends HttpServlet {

    public regUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("registerPage.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("emailAddress");
        System.out.println("This is the email:  " + email);

        Users user = new Users();
        SendMail newSend = new SendMail();

        user.setEmailAddress(email);

//        String registeredEmail = user.getEmailAddress();

        UsersDB userDB = new UsersDB();

        try {
            if (userDB.checkUserExists(user)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("errorRegister.jsp");
                dispatcher.forward(request, response);

            } else {

                userDB.registerUser(user);

                RequestDispatcher dispatcher = request.getRequestDispatcher("registerSuccessful.jsp");
                dispatcher.forward(request, response);
                
                String usPwd = user.getGeneratedPassword();
                newSend.email(email, usPwd);

            }

        } catch (AddressException ex) {
            Logger.getLogger(regUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(regUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//                
    }

}
