package Architecture.Modle;

import Database.DBConnection;
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

}
