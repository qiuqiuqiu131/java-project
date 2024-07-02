package Architecture.Command.Log;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.IDataBaseModle;
import Architecture.Utility.IEncodeUtility;
import Tool.Database.Class.ClientData;
import Tool.framework.Abstract.AbstractCommand;

/**
 * 客户注销命令
 */
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
            String decodePwd = this.GetUtility(IEncodeUtility.class).decode(data.Password, "加密");
            if (data.Password.equals(decodePwd)) {
                dBaseModle.ClientLogout(Name);
                inputMgr.PrintLine(PrintGrade.Imforation, "客户注销成功");
            } else {
                inputMgr.PrintLine(PrintGrade.Error, "密码错误");
            }
        }
    }

}
