package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private final String url = "jdbc:mysql://localhost:3306/PrivateSchool?serverTimezone=UTC";
    private final String username = "root";
    private final String pass = "newpassword";
    private Connection conn;

    public DBConnect() {

    }

    public Connection getConnection() {

        System.out.println("Creating Connection to DB...");

        try {
            conn = DriverManager.getConnection(url, username, pass);
            System.out.println("Connected YEAH!!!");
        } catch (SQLException ex) {
            /*
            to see where the problem is
            ex.printStackTrace();
             */
            System.out.println("Connection Failed!!!");
        }
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            /*
            to see where the problem is
            ex.printStackTrace();
             */
            System.out.println("Connection Failed!!!");
        }
    }
}
