package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {

    private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=JSP_ATJP;integratedSecurity=false;encrypt=false;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "bigStrongPwd";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
        	System.out.print("success");
            e.printStackTrace();
        } catch (SQLException e) {
        	
            e.printStackTrace();
        }
        return conn;
    }
}
