package Architecture.Command;

import Architecture.Controller.IInputManager;
import Architecture.Controller.IPanelManager;
import Architecture.Controller.PrintGrade;
import Architecture.View.PanelType;
import Tool.framework.Abstract.AbstractCommand;

/**
 * 客户登录命令
 */
public class ClientLoginCommand extends AbstractCommand {
    public String Name;
    public String Password;

    public ClientLoginCommand(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    @Override
    protected void OnExecute() {
        IInputManager inputMgr = this.GetController(IInputManager.class);
        inputMgr.PrintLine(PrintGrade.Imforation, "客户登录成功");
        this.GetController(IPanelManager.class).ClosePanel();
        this.GetController(IPanelManager.class).OpenPanel(PanelType.ClientPanel);
    }
}
