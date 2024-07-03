package Architecture.Modle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Architecture.Event.SalerEnterEvent;
import Architecture.Modle.IModle.IDataBaseModle;
import Architecture.Modle.IModle.ISalerModle;
import Tool.Database.Class.ItemData;
import Tool.framework.Abstract.AbstractModle;
import Tool.framework.Event.IEventListener;

public class SalerModle extends AbstractModle
        implements ISalerModle,
        IEventListener<SalerEnterEvent> {
    private String Name;

    @Override
    protected void OnInit() {
        this.RegisterEvent(SalerEnterEvent.class, this);
    }

    @Override
    public void Invoke(SalerEnterEvent obj) {
        Name = obj.Name;
    }

    @Override
    public List<ItemData> GetItemData() throws SQLException {
        IDataBaseModle dBaseModle = this.GetModle(IDataBaseModle.class);

        String Sql = String.format(
                "SELECT itemname, price, belong, clientname, date " + //
                        "FROM item " + //
                        "WHERE salername = '%s'",
                Name);
        try {
            ResultSet res = dBaseModle.ExecuteQuery(Sql);
            List<ItemData> result = new ArrayList<ItemData>();

            while (res.next()) {
                ItemData itemData = new ItemData();
                itemData.itemName = res.getString("itemname");
                itemData.Price = res.getInt("price");
                itemData.Belong = res.getString("belong");
                itemData.clientName = res.getString("clientname");
                itemData.Date = res.getString("date");
                result.add(itemData);
            }
            return result;
        } catch (SQLException e) {
            throw e;
        }
    }

}
