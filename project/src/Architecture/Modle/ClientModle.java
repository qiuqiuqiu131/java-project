package Architecture.Modle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Architecture.Event.ClientEnterEvent;
import Architecture.Modle.IModle.IClientModle;
import Architecture.Modle.IModle.IDataBaseModle;
import Tool.Database.Class.ItemData;
import Tool.framework.Abstract.AbstractModle;
import Tool.framework.Event.IEventListener;

public class ClientModle
        extends AbstractModle
        implements IClientModle,
        IEventListener<ClientEnterEvent> {
    private String Name;

    @Override
    public void Invoke(ClientEnterEvent obj) {
        Name = obj.Name;
    }

    @Override
    protected void OnInit() {
        this.RegisterEvent(ClientEnterEvent.class, this);
    }

    @Override
    public List<ItemData> GetItemData() throws SQLException {
        IDataBaseModle dBaseModle = this.GetModle(IDataBaseModle.class);

        String Sql = String.format(
                "SELECT i.itemname itemname, s.price price, s.belong belong, i.salername salername, i.date date\n" + //
                        "FROM item i JOIN software s on i.itemname = s.name\n" + //
                        "WHERE clientname = '%s'",
                Name);
        try {
            ResultSet res = dBaseModle.ExecuteQuery(Sql);
            List<ItemData> result = new ArrayList<ItemData>();

            while (res.next()) {
                ItemData itemData = new ItemData();
                itemData.itemName = res.getString("itemname");
                itemData.salerName = res.getString("salername");
                itemData.Belong = res.getString("belong");
                itemData.Price = res.getInt("price");
                itemData.Date = res.getString("date");
                result.add(itemData);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public String GetClinetName() {
        return Name;
    }

}
