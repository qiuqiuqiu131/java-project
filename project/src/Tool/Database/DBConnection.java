package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final String userName = "root";
    private final String password = "123456";
    private final String url = "jdbc:mysql://localhost:3306/sw_system";

    private Connection conn = null;

    public Connection GetConn() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, userName, password);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return conn;
    }
}
