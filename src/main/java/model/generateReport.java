/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author User
 */
public class generateReport {
    Class.forName("oracle.jdbc.OracleDriver");
Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:personnel","user","password");

try {
   File reportFile = new File(application.getRealPath("//reports//rapport_absences.jasper"));
    Map h = new HashMap();

    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),h,cn);

    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition",  "inline; filename=report.pdf ");
    response.setContentLength(bytes.length);
    ServletOutputStream outStream = response.getOutputStream();
    outStream.write(bytes,0,bytes.length);
    outStream.flush();
    outStream.close();

}catch (Exception ex){
    ex.printStackTrace()
}
