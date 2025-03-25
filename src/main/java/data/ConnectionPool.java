/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author zurion
 */
class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    public ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("JAVA:/comp/env/jdbc/UsersRegistered");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;

    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();

        } catch (SQLException sey) {
            sey.printStackTrace(System.err);
            return null;
        }
    }

    public void freeConnection(Connection c) {
        if (c != null) {
            try {
                if (!c.getAutoCommit()) {
                    c.setAutoCommit(true);
                }
                c.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

    }
}
