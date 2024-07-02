package Architecture.Modle.IModle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Tool.Database.Class.ClientData;
import Tool.Database.Class.ClientRecord;
import Tool.Database.Class.FirmRecord;
import Tool.Database.Class.SalerData;
import Tool.Database.Class.SalerRecord;
import Tool.framework.Interface.IModle;

public interface IDataBaseModle extends IModle {
    // 判断是否存在客户
    boolean ClientContained(String name);

    // 获取客户信息
    ClientData GetClient(String name);

    // 注册客户
    void ClientAdd(String name, String password) throws Exception;

    // 注销客户
    void ClientLogout(String name);

    // 判断是否存在销售员
    boolean SalerContained(String name);

    // 获取销售员信息
    SalerData GetSaler(String name);

    // 注册销售员
    void SalerAdd(String name, String passString) throws Exception;

    // 注销销售员
    void SalerLogout(String name);

    // 获取客户信息
    List<ClientRecord> GetClientRecord() throws SQLException;

    // 获取销售员信息
    List<SalerRecord> GetSalerRecord() throws SQLException;

    // 获取厂商信息
    List<FirmRecord> GetFirmRecord() throws SQLException;

    ResultSet ExecuteQuery(String sql) throws SQLException;
}
