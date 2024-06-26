package Architecture.Modle.IModle;

import Tool.Database.Class.ClientData;
import Tool.Database.Class.SalerData;
import Tool.framework.Interface.IModle;

public interface IDataBaseModle extends IModle {
    // 判断是否存在客户
    boolean ClientContained(String name);

    // 获取客户信息
    ClientData GetClient(String name);

    // 注册客户
    int ClientAdd(String name, String password);

    // 判断是否存在销售员
    boolean SalerContained(String name);

    // 获取销售员信息
    SalerData GetSaler(String name);

    // 注册销售员
    int SalerAdd(String name, String passString);
}
