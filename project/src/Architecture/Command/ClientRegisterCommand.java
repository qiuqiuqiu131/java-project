package Architecture.Command;

import Architecture.Controller.IInputManager;
import Architecture.Controller.IPanelManager;
import Architecture.Controller.PrintGrade;
import Architecture.Event.ClientEnterEvent;
import Architecture.View.PanelType;
import Tool.framework.Abstract.AbstractCommand;

/**
 * 客户注册命令
 */
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
        inputMgr.PrintLine(PrintGrade.Imforation, "客户注册成功");

        this.SendEvent(new ClientEnterEvent("0", Name));

        this.GetController(IPanelManager.class).ClosePanel();
        this.GetController(IPanelManager.class).OpenPanel(PanelType.ClientPanel);
    }

}
