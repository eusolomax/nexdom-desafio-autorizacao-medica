package br.com.nexdom.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {

    private static final String URL = "jdbc:h2:./database/autorizacao";
    // private static final String URL = "jdbc:h2:file:./database/autorizacao";

    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}