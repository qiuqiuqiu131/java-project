package Command;

import Manager.IInputManager;
import Manager.IPanelManager;
import Manager.PrintGrade;
import Tool.framework.Abstract.AbstractCommand;
import View.PanelType;

public class ClientRegisterCommand extends AbstractCommand {
    public String Name;
    public String Password;

    public ClientRegisterCommand(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    @Override
    protected void OnExecute() {
        IInputManager inputMgr = this.GetController(IInputManager.class);
        inputMgr.PrintLine(PrintGrade.Imforation, "登录成功");
        inputMgr.PrintLine(PrintGrade.Execute, "切换到用户界面");
        this.GetController(IPanelManager.class).ClosePanel();
        this.GetController(IPanelManager.class).OpenPanel(PanelType.ClientPanel);
    }

}
