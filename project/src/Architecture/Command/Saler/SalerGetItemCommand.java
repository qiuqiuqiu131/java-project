package Architecture.Command.Saler;

import java.sql.SQLException;
import java.util.List;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.ISalerModle;
import Tool.Database.Class.ItemData;
import Tool.framework.Abstract.AbstractCommand;

public class SalerGetItemCommand extends AbstractCommand {
    @Override
    protected void OnExecute() {
        ISalerModle salerModle = this.GetModle(ISalerModle.class);
        IInputManager inputManager = this.GetController(IInputManager.class);

        try {
            List<ItemData> reslut = salerModle.GetItemData();

            inputManager.Space();
            System.out.println("--------购买记录--------");
            if (reslut.size() == 0) {
                System.out.println("暂无数据");
            } else {
                System.out.println("软件名\t价格\t出厂商\t客户\t购买日期");
                for (ItemData res : reslut) {
                    System.out.println(
                            String.format("%s\t%d\t%s\t%s\t%s",
                            res.itemName, res.Price, res.Belong, res.clientName, res.Date));
                }
            }
            System.out.println("-----------------------");
            inputManager.GetInputLine();

        } catch (SQLException e) {
            inputManager.PrintLine(PrintGrade.Error, "查询错误");
        }
    }
}
