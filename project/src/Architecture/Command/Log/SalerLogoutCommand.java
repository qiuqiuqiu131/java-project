package Architecture.Command.Log;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Modle.IModle.IDataBaseModle;
import Architecture.Utility.IEncodeUtility;
import Tool.Database.Class.SalerData;
import Tool.framework.Abstract.AbstractCommand;

/**
 * 销售员注销接口
 */
public class SalerLogoutCommand extends AbstractCommand {

    public String Name;
    public String Password;

    public SalerLogoutCommand(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    @Override
    protected void OnExecute() {
        IInputManager inputMgr = this.GetController(IInputManager.class);
        IDataBaseModle dBaseModle = this.GetModle(IDataBaseModle.class);

        if (!dBaseModle.ClientContained(Name)) {
            inputMgr.PrintLine(PrintGrade.Error, "销售员不存在");
        } else {
            SalerData data = dBaseModle.GetSaler(Name);
            String decodePwd = this.GetUtility(IEncodeUtility.class).decode(data.Password, "加密");
            if (Password.equals(decodePwd)) {
                dBaseModle.SalerLogout(Name);
                inputMgr.PrintLine(PrintGrade.Imforation, "销售员注销成功");
            } else {
                inputMgr.PrintLine(PrintGrade.Error, "密码错误");
            }
        }
    }

}
