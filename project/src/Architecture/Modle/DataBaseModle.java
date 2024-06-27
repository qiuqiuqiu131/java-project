package Architecture.Modle;

import java.sql.PreparedStatement;
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

    public DataBaseModle() {
        dbConnection = new DBConnection();
    }

    @Override
    protected void OnInit() {
        dbConnection.GetConn();
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
                String Name = res.getString("name");
                String Password = res.getString("password");
                return new ClientData(Name, Password);
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public void ClientAdd(String name, String password) throws Exception {
        String sql = "INSERT INTO client(name,password) VALUES(?,?)";
        try (PreparedStatement pStatement = dbConnection.GetConn().prepareStatement(sql)) {
            pStatement.setString(1, name);
            pStatement.setString(2, password);

            pStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void ClientLogout(String name) {
        String sql = "DELETE FROM client WHERE client.name = ?";
        try (PreparedStatement pStatement = dbConnection.GetConn().prepareStatement(sql)) {
            pStatement.setString(1, name);
            pStatement.executeUpdate();
        } catch (Exception e) {
        }
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
                String Name = res.getString("name");
                String Password = res.getString("password");
                return new SalerData(Name, Password);
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public void SalerAdd(String name, String password) throws Exception {
        String sql = "INSERT INTO saler(name,password) VALUES(?,?)";
        try (PreparedStatement pStatement = dbConnection.GetConn().prepareStatement(sql)) {
            pStatement.setString(1, name);
            pStatement.setString(2, password);

            pStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void SalerLogout(String name) {
        String sql = "DELETE FROM saler WHERE saler.name = ?";
        try (PreparedStatement pStatement = dbConnection.GetConn().prepareStatement(sql)) {
            pStatement.setString(1, name);
            pStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    private ResultSet ExecuteSql(String sql) throws SQLException {
        Statement statement = dbConnection.GetConn().createStatement();
        return statement.executeQuery(sql);
    }
}
