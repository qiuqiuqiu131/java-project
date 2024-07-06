package Architecture.Command.Log;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Controller.IController.IPanelManager;
import Architecture.Event.SalerEnterEvent;
import Architecture.Modle.IModle.IDataBaseModle;
import Architecture.Utility.IEncodeUtility;
import Architecture.View.PanelType;
import Tool.Database.Class.SalerData;
import Tool.framework.Abstract.AbstractCommand;

/**
 * 销售员登录命令
 */
public class SalerLoginCommand extends AbstractCommand {
    public String Name;
    public String Password;

    public SalerLoginCommand(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    @Override
    protected void OnExecute() {
        IInputManager inputMgr = this.GetController(IInputManager.class);
        IDataBaseModle dBaseModle = this.GetModle(IDataBaseModle.class);

        if (!dBaseModle.SalerContained(Name)) {
            inputMgr.PrintLine(PrintGrade.Error, "销售员不存在,请先注册");
        } else {
            SalerData data = dBaseModle.GetSaler(Name);
            String decodePwd = this.GetUtility(IEncodeUtility.class).decode(data.Password, "加密");
            if (Password.equals(decodePwd)) {
                this.SendEvent(new SalerEnterEvent(Name));

                inputMgr.PrintLine(PrintGrade.Imforation, "销售员登录成功");

                this.GetController(IPanelManager.class).ClosePanel();
                this.GetController(IPanelManager.class).OpenPanel(PanelType.SalerPanel);
            } else {
                inputMgr.PrintLine(PrintGrade.Error, "密码错误");
            }
        }
    }
}
