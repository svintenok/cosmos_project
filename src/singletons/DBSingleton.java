package singletons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */

public class DBSingleton {

    private static final String URL = "jdbc:postgresql://localhost:5432/CosmosProjectDb?charSet=utf-8?characterEncoding=utf-8";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String DRIVER = "org.postgresql.Driver";

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null){

            try {
                Class.forName(DRIVER);
                Properties properties=new Properties();
                properties.setProperty("user",USERNAME);
                properties.setProperty("password", PASSWORD);
                properties.setProperty("useUnicode", "true");
                properties.setProperty("characterEncoding", "UTF-8");
                conn = DriverManager.getConnection(URL, properties);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return conn;
    }
}
