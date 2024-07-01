package Tool.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final static String userName = "root";
    private final static String password = "123456";
    private final static String url = "jdbc:mysql://localhost:3306/qiuqiuqiu";

    private Connection conn = null;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.err.println("数据库连接失败");
        }
    }

    public Connection GetConn() {
        return conn;
    }
}
