package singletons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {

    private static final String URL = "jdbc:postgresql://localhost:5432/CosmosProjectDb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String DRIVER = "org.postgresql.Driver";

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null){

            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return conn;
    }

}
