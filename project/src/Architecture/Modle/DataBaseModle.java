package Architecture.Modle;

import Architecture.Modle.IModle.IDataBaseModle;
import Tool.Database.DBConnection;
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
