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
                "SELECT i.itemname name, s.belong firmname, s.price price, i.date date,i.salername salername " + //
                        "FROM item i JOIN software s on i.itemname = s.name " + //
                        "WHERE i.clientname = '%s'",
                Name);
        try {
            ResultSet res = dBaseModle.ExecuteQuery(Sql);
            List<ItemData> result = new ArrayList<ItemData>();

            while (res.next()) {
                ItemData itemData = new ItemData();
                itemData.salerName = res.getString("salername");
                itemData.Date = res.getString("date");
                itemData.firmName = res.getString("firmname");
                itemData.price = res.getInt("price");
                itemData.itemName = res.getString("name");

                result.add(itemData);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

}
