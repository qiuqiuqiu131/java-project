package Architecture.Modle.IModle;

import java.sql.SQLException;
import java.util.List;

import Tool.Database.Class.ItemData;
import Tool.framework.Interface.IModle;

public interface IClientModle
        extends IModle {
    List<ItemData> GetItemData() throws SQLException;
}
