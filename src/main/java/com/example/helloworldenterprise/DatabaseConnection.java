package com.example.helloworldenterprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance = new DatabaseConnection();
    public static final String URL = "jdbc:h2:file:~/users";
    public static final String USER = "sa";
    public static final String PASSWORD = "";
    public static final String DRIVER_CLASS = "org.h2.Driver";
//    final String[] args = new String[]{"-tcpPort", "8092", "-ifNotExists", "true"};

    //private constructor
    private DatabaseConnection() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            org.h2.tools.Server server = org.h2.tools.Server.createTcpServer(args).start();
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

    public static void endConnection(Connection con) {
        instance.closeConnection(con);
    }

    private void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error Closing connection...");
        }
    }


}
