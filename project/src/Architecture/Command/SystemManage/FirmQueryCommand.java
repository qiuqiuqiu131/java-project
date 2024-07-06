package Architecture.Command.SystemManage;

import java.sql.SQLException;
import java.util.List;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.IDataBaseModle;
import Tool.Database.Class.FirmRecord;
import Tool.framework.Abstract.AbstractCommand;

public class FirmQueryCommand extends AbstractCommand {

    @Override
    protected void OnExecute() {
        IDataBaseModle dataBaseModle = this.GetModle(IDataBaseModle.class);
        IInputManager inputManager = this.GetController(IInputManager.class);

        try {
            List<FirmRecord> list = dataBaseModle.GetFirmRecord();

            inputManager.Space();
            System.out.println("--------厂商查询--------");
            if (list.size() == 0) {
                System.out.println("暂无数据");
            } else {
                System.out.println("厂商\t地址");
                for (FirmRecord c : list) {
                    System.out.println(String.format("%s\t%s", c.Name, c.Location));
                }
            }
            System.out.println("-----------------------");
            inputManager.GetInputLine();

        } catch (SQLException e) {
            inputManager.PrintLine(PrintGrade.Error, "查询失败");
        }
    }

}
