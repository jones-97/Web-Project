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
import model.Users;
import data.UsersDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zurion
 */
public class logInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("emailAddress");
        String pwd = request.getParameter("password");
        String resultMessage = "";

//       Users verifyingUser = new Users();
//       verifyingUser.setEmailAddress(user);
//        
        
        
       HttpSession session = request.getSession();
       session.setAttribute("Email", user);
        
        UsersDB verifyUserDB = new UsersDB();

        try {
            if (verifyUserDB.verifyUserAccount(pwd, user)) {
                
               
                
                RequestDispatcher rd = request.getRequestDispatcher("userHome.jsp");
                
                 
                 rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("backToIndex.jsp");
                
                rd.forward(request, response);

            }
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(logInServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(logInServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
