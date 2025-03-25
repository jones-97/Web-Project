/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.UsersDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Users;

/**
 *
 * @author zurion
 */
public class updDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("updateAccount.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");

        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));

        String address = request.getParameter("address");

        String email = request.getParameter("hiddenEmail");

        Users updatingUser = new Users();
        updatingUser.setFirstName(firstName);
        updatingUser.setLastName(lastName);
        updatingUser.setDob(dob);
        updatingUser.setPhoneNumber(phoneNumber);
        updatingUser.setAddress(address);

        UsersDB userDB = new UsersDB();
        HttpSession session2 = request.getSession();
        session2.setAttribute("user", updatingUser);
        try {

            userDB.updateUserDetails(updatingUser, email);
            RequestDispatcher rd = request.getRequestDispatcher("updateSuccess.jsp");
            rd.forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // userDB.
    }

}
