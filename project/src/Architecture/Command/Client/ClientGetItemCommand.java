package Architecture.Command.Client;

import java.sql.SQLException;
import java.util.List;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.IClientModle;
import Tool.Database.Class.ItemData;
import Tool.framework.Abstract.AbstractCommand;

public class ClientGetItemCommand extends AbstractCommand {
    @Override
    protected void OnExecute() {
        IClientModle clientModle = this.GetModle(IClientModle.class);
        IInputManager inputManager = this.GetController(IInputManager.class);

        try {
            List<ItemData> reslut = clientModle.GetItemData();

            inputManager.Space();
            System.out.println("--------购买记录--------");
            if (reslut.size() == 0) {
                System.out.println("暂无数据");
            } else {
                System.out.println("软件名\t价格\t出厂商\t销售员\t购买日期");
                for (ItemData res : reslut) {
                    System.out.println(
                            String.format("%s\t%d\t%s\t%s\t%s",
                            res.itemName, res.Price, res.Belong, res.salerName, res.Date));
                }
            }
            System.out.println("-----------------------");
            inputManager.GetInputLine();

        } catch (SQLException e) {
            inputManager.PrintLine(PrintGrade.Error, "查询错误");
        }
    }

}
