package Architecture.Command.Log;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Controller.IController.IPanelManager;
import Architecture.Event.SalerEnterEvent;
import Architecture.Modle.IModle.IDataBaseModle;
import Architecture.Utility.IEncodeUtility;
import Architecture.View.PanelType;
import Tool.framework.Abstract.AbstractCommand;

/**
 * 销售员注册命令
 */
public class SalerRegisterCommand extends AbstractCommand {
    public String Name;
    public String Password;

    public SalerRegisterCommand(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    @Override
    protected void OnExecute() {
        IInputManager inputMgr = this.GetController(IInputManager.class);
        IDataBaseModle dBaseModle = this.GetModle(IDataBaseModle.class);

        if (dBaseModle.SalerContained(Name)) {
            inputMgr.PrintLine(PrintGrade.Error, "用户名已存在");
        } else {
            // String encodePwd = this.GetUtility(IEncodeUtility.class).encode("加密",
            // Password);
            try {
                dBaseModle.SalerAdd(Name, Password);

                this.SendEvent(new SalerEnterEvent(Name));
                inputMgr.PrintLine(PrintGrade.Imforation, "销售员注册成功");

                this.GetController(IPanelManager.class).ClosePanel();
                this.GetController(IPanelManager.class).OpenPanel(PanelType.SalerPanel);
            } catch (Exception e) {
                inputMgr.PrintLine(PrintGrade.Error, "注册失败");
            }
        }
    }

}
