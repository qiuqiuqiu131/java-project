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
                "SELECT i.itemname name, s.belong firmname, s.price price, i.date date,i.clientname clientname " + //
                        "FROM item i JOIN software s on i.itemname = s.name " + //
                        "WHERE i.clientname = '%s'",
                Name);
        try {
            ResultSet res = dBaseModle.ExecuteQuery(Sql);
            List<ItemData> result = new ArrayList<ItemData>();

            while (res.next()) {
                ItemData itemData = new ItemData();
                itemData.clientName = res.getString("clientname");
                itemData.Date = res.getString("date");
                itemData.firmName = res.getString("belong");
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
