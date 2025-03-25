/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import model.Users;
import java.sql.*;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;

/**
 *
 * @author zurion
 */
public class UsersDB {

    String checkString = "";

    public boolean checkUserExists(Users registeredPerson) throws ClassNotFoundException, SQLException {

        PreparedStatement userStatement = null;
        String checkEmail;

        try {

            String userEmail = registeredPerson.getEmailAddress();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection checkCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsersRegistered", "root", "");

            checkCon.setAutoCommit(false);
            checkString = "SELECT * FROM Users WHERE emailAddress = ?";
            userStatement = checkCon.prepareStatement(checkString);
            userStatement.setString(1, userEmail);

            ResultSet results = userStatement.executeQuery();

            if (results.next()) {
                System.out.println("Similar email detected.\n\n\n");

            } else {
                System.out.println("User not yet created\n\n\n");
                return false;
            }

            checkCon.commit();
            userStatement.close();
            checkCon.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;

    }

    public static int registerUser(Users registeredPerson) throws ClassNotFoundException, SQLException {

        String userEmail = registeredPerson.getEmailAddress();
        String userPassword = registeredPerson.getGeneratedPassword();

        System.out.println("GENERATED PASSWORD: " + userPassword + "\n\n");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection registerCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsersRegistered", "root", "");
        PreparedStatement userStatement = null;

        try {

            registerCon.setAutoCommit(false);
            String insertString = "INSERT INTO Users (emailAddress, Password) VALUES ('" + userEmail
                    + "', MD5('" + userPassword + "'))";
            userStatement = registerCon.prepareStatement(insertString);

            int i = userStatement.executeUpdate();

            System.out.println("Rows impacted: " + i);
            registerCon.commit();
            userStatement.close();
            registerCon.close();

            System.out.println("SUCCESS");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return 0;

    }

    public boolean verifyUserAccount(String userPassword, String userEmail) throws ClassNotFoundException, SQLException {

        Users registeredPerson = new Users();

//         userPassword = registeredPerson.getGeneratedPassword();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection verifyCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsersRegistered", "root", "");
        PreparedStatement verifiedStatement = null;

        try {

            verifyCon.setAutoCommit(false);

            checkString = "SELECT * FROM Users WHERE emailAddress = ? AND Password = MD5('" + userPassword + "')";
            verifiedStatement = verifyCon.prepareStatement(checkString);

            verifiedStatement.setString(1, userEmail);

            ResultSet verifySet = verifiedStatement.executeQuery();

            if (verifySet.next()) {
                System.out.println("Authentication verified");

            } else {
                System.out.println("Incorrent Username or Password");
                return false;
            }

            verifyCon.commit();
            verifiedStatement.close();
            verifyCon.close();

        } catch (SQLException e) {
            e.getMessage();
        }

        return true;
    }

    public int updateUserDetails(Users updateUser, String emailAddress) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection registerCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsersRegistered", "root", "");
        PreparedStatement userStatement = null;
        
        String fName = updateUser.getFirstName();
        String lName = updateUser.getLastName();
        String date = updateUser.getDob();
        int phone = updateUser.getPhoneNumber();
        String location = updateUser.getAddress();

        try {

            registerCon.setAutoCommit(false);
            String insertString = "UPDATE Users "
                    + "SET firstName = ?, lastName=?, dob=?, phoneNumber=?, address=? "
                    + "WHERE emailAddress= ?";
            userStatement = registerCon.prepareStatement(insertString);

            userStatement.setString(1, fName);
            userStatement.setString(2, lName);
            userStatement.setString(3, date);
            userStatement.setInt(4, phone);
            userStatement.setString(5, location);
            userStatement.setString(6, emailAddress);
            
            int i = userStatement.executeUpdate();

            System.out.println("Rows impacted: " + i);
            registerCon.commit();
            userStatement.close();
            registerCon.close();

            System.out.println("SUCCESS");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return 0;

    }
    
//    public boolean checkUserDetails(String email) {
//        
//        PreparedStatement userStatement = null;
//        
//
//        try {
//
//            
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection checkCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsersRegistered", "root", "");
//
//            checkCon.setAutoCommit(false);
//            
//            checkString = "SELECT firstName, lastName FROM Users WHERE emailAddress = ?";
//            userStatement = checkCon.prepareStatement(checkString);
//            userStatement.setString(1, userEmail);
//
//            ResultSet results = userStatement.executeQuery();
//
//            if (results.next()) {
//                System.out.println("Similar email detected.\n\n\n");
//
//            } else {
//                System.out.println("User not yet created\n\n\n");
//                return false;
//            }
//
//            checkCon.commit();
//            userStatement.close();
//            checkCon.close();
//
//        } catch (SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        
//        
//        return true;
//    } 

    public void generateReport() {
        
    }
}
