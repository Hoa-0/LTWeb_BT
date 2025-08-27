package vn.iotstar.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private final String serverName = "localhost";   // hoặc 127.0.0.1
    private final String dbName = "LapTrinhWeb";           // đổi theo tên DB của bạn
    private final String portNumber = "1433";        // mặc định SQL Server
    private final String instance = "";              // nếu dùng SQLEXPRESS thì ghi "SQLEXPRESS"
    private final String userID = "sa";              // user SQL Server
    private final String password = "123456";        // password SQL Server

    public Connection getConnection() throws SQLException {
        String url;

        // nếu instance rỗng
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                    + ";databaseName=" + dbName
                    + ";user=" + userID
                    + ";password=" + password
                    + ";encrypt=true;trustServerCertificate=true";
        } else {
            // nếu có instance
            url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber
                    + ";databaseName=" + dbName
                    + ";user=" + userID
                    + ";password=" + password
                    + ";encrypt=true;trustServerCertificate=true";
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQL Server JDBC Driver not found.", e);
        }

        return DriverManager.getConnection(url);
    }

    // test connection
    public static void main(String[] args) {
        try (Connection c = new DBConnect().getConnection()) {
            System.out.println("Kết nối thành công: " + (c != null && !c.isClosed()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
