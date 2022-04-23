package com.tesda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Data Access Object
 *
 */
public class Dao {

    private String url = "jdbc:mysql://localhost/inventory-system-db";
    private String username = "root";
    private String password = "";
    protected Connection conn;

    //Constructor
    public Dao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.getConnection(url, username, password);
    }

    public void close() throws SQLException {
        conn.close();
    }

}
