package Architecture.Command.Client;

import java.sql.SQLException;
import java.util.List;

import Architecture.Command.ResultClass.SearchDataReturn;
import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.IDataBaseModle;
import Tool.Database.Class.SoftwareData;
import Tool.framework.Abstract.AbstractResCommand;

public class ClientGetSoftwareByDescriptionCommand extends AbstractResCommand<SearchDataReturn> {
    public String Description;

    public ClientGetSoftwareByDescriptionCommand(String description){
        Description=description;
    }
    @Override
    protected SearchDataReturn OnExecute() {
        IDataBaseModle dataBaseModle=this.GetModle(IDataBaseModle.class);
        IInputManager inputManager=this.GetController(IInputManager.class);
        SearchDataReturn temp=new SearchDataReturn();
        try {
            List<SoftwareData> list=dataBaseModle.GetSoftwareDataBydescription(this.Description);
            inputManager.Space();
            System.out.println("--------查询结果--------");
            if (list.size() == 0) {
                System.out.println("暂无数据");
            } else {
                System.out.println("软件名\t出厂商\t价格");
                for (SoftwareData c : list) {
                        temp.list.add(c);
                        System.out.println(String.format("%s\t%s\t%d",c.Name,c.Belong,c.Price));
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
