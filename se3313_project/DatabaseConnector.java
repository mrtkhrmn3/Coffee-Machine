/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mert
 */
public class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/se3313_project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Mert42582001";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
