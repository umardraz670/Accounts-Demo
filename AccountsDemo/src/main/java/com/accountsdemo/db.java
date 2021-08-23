/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accountsdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Orax Solution Provider +923219598676
 */
public class db {

    protected static String DB_URL = "jdbc:mysql://localhost:3306/urdu-bazaar";
    protected static String DRIVER_URL = "com.mysql.cj.jdbc.Driver";
    protected static String USER = "root";
    protected static String PASSWORD = "root1234$";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con;
        Class.forName(DRIVER_URL);
        con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        con.setAutoCommit(false);
        return con;
    }

}
