package Architecture.Modle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Architecture.Modle.IModle.IDataBaseModle;
import Tool.Database.DBConnection;
import Tool.Database.Class.ClientData;
import Tool.Database.Class.SalerData;
import Tool.framework.Abstract.AbstractModle;

public class DataBaseModle extends AbstractModle implements IDataBaseModle {
    private DBConnection dbConnection;
    private int clientCount;
    private int salerCount;

    public DataBaseModle() {
        dbConnection = new DBConnection();
    }

    @Override
    protected void OnInit() {
        dbConnection.GetConn();

        clientCount = ClientCount();
        salerCount = SalerCount();

        System.out.println(clientCount + " " + salerCount);
    }

    @Override
    public boolean ClientContained(String name) {
        try {
            String sql = String.format("SELECT * FROM client WHERE client.name == '%s'", name);
            ResultSet res = ExecuteSql(sql);
            return res.next();
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public ClientData GetClient(String name) {
        try {
            String sql = String.format("SELECT * FROM client WHERE client.name == '%s'", name);
            ResultSet res = ExecuteSql(sql);
            if (res.next()) {
                String Id = res.getString("id");
                String Name = res.getString("name");
                String Password = res.getString("password");
                return new ClientData(Id, Name, Password);
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public boolean SalerContained(String name) {
        try {
            String sql = String.format("SELECT * FROM saler WHERE saler.name == '%s'", name);
            ResultSet res = ExecuteSql(sql);
            return res.next();
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public SalerData GetSeler(String name) {
        try {
            String sql = String.format("SELECT * FROM saler WHERE saler.name == '%s'", name);
            ResultSet res = ExecuteSql(sql);
            if (res.next()) {
                String Id = res.getString("id");
                String Name = res.getString("name");
                String Password = res.getString("password");
                return new SalerData(Id, Name, Password);
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public int ClientAdd(String name, String password) {
        try {
            String sql = String.format("INSERT INTO client VALUES('%s','%s','%s')", String.valueOf(clientCount + 1),
                    name, password);
            ExecuteSql(sql);
            clientCount++;
            return clientCount;
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public int SalerAdd(String name, String password) {
        try {
            String sql = String.format("INSERT INTO saler VALUES('%s','%s','%s')", salerCount + 1, name, password);
            ExecuteSql(sql);
            salerCount++;
            return clientCount;
        } catch (SQLException e) {
            return -1;
        }
    }

    private int ClientCount() {
        try {
            String sql = "SELECT COUNT(*) AS c FROM client";
            ResultSet res = ExecuteSql(sql);
            if (res.next())
                return res.getInt("c");
            else
                return 0;
        } catch (SQLException e) {
            return 0;
        }
    }

    private int SalerCount() {
        try {
            String sql = "SELECT COUNT(*) AS c FROM saler";
            ResultSet res = ExecuteSql(sql);
            if (res.next())
                return res.getInt("c");
            else
                return 0;
        } catch (SQLException e) {
            return 0;
        }
    }

    private ResultSet ExecuteSql(String sql) throws SQLException {
        Statement statement = dbConnection.GetConn().createStatement();
        return statement.executeQuery(sql);
    }
}
