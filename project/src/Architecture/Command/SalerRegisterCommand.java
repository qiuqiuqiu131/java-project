package Architecture.Command;

import Architecture.Controller.IInputManager;
import Architecture.Controller.IPanelManager;
import Architecture.Controller.PrintGrade;
import Architecture.Event.SalerEnterEvent;
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
        inputMgr.PrintLine(PrintGrade.Imforation, "销售员注册成功");

        this.SendEvent(new SalerEnterEvent("0", Name));

        this.GetController(IPanelManager.class).ClosePanel();
        this.GetController(IPanelManager.class).OpenPanel(PanelType.SalerPanel);
    }

}
