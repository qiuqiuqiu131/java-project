package Architecture.Command;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.IDataBaseModle;
import Tool.Database.Class.ClientData;
import Tool.framework.Abstract.AbstractCommand;

public class ClientLogoutCommand extends AbstractCommand {
    public String Name;
    public String Password;

    public ClientLogoutCommand(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    @Override
    protected void OnExecute() {
        IInputManager inputMgr = this.GetController(IInputManager.class);
        IDataBaseModle dBaseModle = this.GetModle(IDataBaseModle.class);

        if (!dBaseModle.ClientContained(Name)) {
            inputMgr.PrintLine(PrintGrade.Error, "客户不存在");
        } else {
            ClientData data = dBaseModle.GetClient(Name);
            if (data.Password.equals(Password)) {
                dBaseModle.ClientLogout(Name);
                inputMgr.PrintLine(PrintGrade.Imforation, "客户注销成功");
            } else {
                inputMgr.PrintLine(PrintGrade.Error, "密码错误");
            }
        }
    }

}
