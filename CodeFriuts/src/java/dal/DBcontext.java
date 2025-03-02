/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBcontext {

    protected Connection connection;

    public DBcontext() {
        try {
            String user = "sa";
            String pass = "sa";
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Y24FA1B1";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}
