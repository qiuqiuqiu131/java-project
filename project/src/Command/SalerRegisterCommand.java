package Command;

import Manager.IInputManager;
import Manager.IPanelManager;
import Manager.PrintGrade;
import Tool.framework.Abstract.AbstractCommand;
import View.PanelType;

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
        this.GetController(IPanelManager.class).ClosePanel();
        this.GetController(IPanelManager.class).OpenPanel(PanelType.SalerPanel);
    }

}
