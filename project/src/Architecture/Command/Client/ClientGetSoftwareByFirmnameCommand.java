package Architecture.Command.Client;

import java.sql.SQLException;
import java.util.List;

import Architecture.Command.ResultClass.SearchDataReturn;
import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.IDataBaseModle;
import Tool.Database.Class.SoftwareData;
import Tool.framework.Abstract.AbstractResCommand;

public class ClientGetSoftwareByFirmnameCommand extends AbstractResCommand<SearchDataReturn> {
    public String firmName;

    public ClientGetSoftwareByFirmnameCommand(String firmname){
        firmName=firmname;
    }
    @Override
    protected SearchDataReturn OnExecute() {
        IDataBaseModle dataBaseModle=this.GetModle(IDataBaseModle.class);
        IInputManager inputManager=this.GetController(IInputManager.class);
        SearchDataReturn temp=new SearchDataReturn();
        try {
            List<SoftwareData> list=dataBaseModle.GetSoftwareDataByfirmname(this.firmName);
            inputManager.Space();
            System.out.println("--------查询结果--------");
            if (list.size() == 0) {
                System.out.println("暂无数据");
            } else {
                System.out.println("软件名\t价格\t功能描述");
                for (SoftwareData c : list) {
                    if(c.Belong==this.firmName){
                        temp.list.add(c);
                        System.out.println(String.format("%s\t%d\t%s",c.Name,c.Price,c.Description));
                    }
                }
            }
            System.out.println("-----------------------");
            inputManager.GetInputLine();

        } catch (SQLException e) {
            inputManager.PrintLine(PrintGrade.Error, "查询失败");
        }
        return temp;
    }

}
