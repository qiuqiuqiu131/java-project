package Architecture.Modle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

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
    }

    @Override
    public boolean ClientContained(String name) {
        try {
            String sql = String.format("SELECT * FROM client WHERE client.name = '%s'", name);
            ResultSet res = ExecuteSql(sql);
            return res.next();
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public ClientData GetClient(String name) {
        try {
            String sql = String.format("SELECT * FROM client WHERE client.name = '%s'", name);
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
            String sql = String.format("SELECT * FROM saler WHERE saler.name = '%s'", name);
            ResultSet res = ExecuteSql(sql);
            return res.next();
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public SalerData GetSaler(String name) {
        try {
            String sql = String.format("SELECT * FROM saler WHERE saler.name = '%s'", name);
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
        String sql = "INSERT INTO client(id,name,password) VALUES(?,?,?)";
        try (PreparedStatement pStatement = dbConnection.GetConn().prepareStatement(sql)) {
            pStatement.setString(1, String.valueOf(clientCount + 1));
            pStatement.setString(2, name);
            pStatement.setString(3, password);

            pStatement.executeUpdate();

            clientCount++;
            return clientCount;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int SalerAdd(String name, String password) {
        String sql = "INSERT INTO saler(id,name,password) VALUES(?,?,?)";
        try (PreparedStatement pStatement = dbConnection.GetConn().prepareStatement(sql)) {
            pStatement.setString(1, String.valueOf(salerCount + 1));
            pStatement.setString(2, name);
            pStatement.setString(3, password);

            pStatement.executeUpdate();

            salerCount++;
            return salerCount;
        } catch (Exception e) {
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
