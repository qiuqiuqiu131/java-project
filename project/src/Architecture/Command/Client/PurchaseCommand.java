package Architecture.Command.Client;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.IClientModle;
import Architecture.Modle.IModle.IDataBaseModle;
import Tool.framework.Abstract.AbstractCommand;

public class PurchaseCommand extends AbstractCommand{
    public String itemName;
    public String salerName;

    public PurchaseCommand(String itemName,String salerName){
        this.itemName=itemName;
        this.salerName=salerName;
    }
    @Override
    protected void OnExecute(){
        IInputManager inputMgr = this.GetController(IInputManager.class);
        IDataBaseModle dBaseModle = this.GetModle(IDataBaseModle.class);
        if(dBaseModle.SoftwareContained(itemName)){
            String Name=this.GetModle(IClientModle.class).GetClinetName();
            try {
                dBaseModle.ItemAdd(itemName,Name,salerName);
                inputMgr.PrintLine(PrintGrade.Error, "购买成功");
            } catch (Exception e) {
                inputMgr.PrintLine(PrintGrade.Error, "购买失败");
            }
        }
        else
            inputMgr.PrintLine(PrintGrade.Error, "软件或销售员不存在");
    }
    
}
