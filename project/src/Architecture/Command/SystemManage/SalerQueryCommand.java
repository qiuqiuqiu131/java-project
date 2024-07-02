package Architecture.Command.SystemManage;

import java.sql.SQLException;
import java.util.List;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.IDataBaseModle;
import Tool.Database.Class.SalerRecord;
import Tool.framework.Abstract.AbstractCommand;

public class SalerQueryCommand extends AbstractCommand {

    @Override
    protected void OnExecute() {
        IDataBaseModle dataBaseModle = this.GetModle(IDataBaseModle.class);
        IInputManager inputManager = this.GetController(IInputManager.class);

        try {
            List<SalerRecord> list = dataBaseModle.GetSalerRecord();

            inputManager.Space();
            System.out.println("--------销售员查询--------");
            if (list.size() == 0) {
                System.out.println("暂无数据");
            } else {
                System.out.println("销售员\t推销数量");
                for (SalerRecord c : list) {
                    System.out.println(String.format("%s\t%s", c.Name, c.SaleCount));
                }
            }
            System.out.println("-----------------------");
            inputManager.GetInputLine();

        } catch (SQLException e) {
            inputManager.PrintLine(PrintGrade.Error, "查询失败");
        }
    }

}
