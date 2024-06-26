package Architecture.Command;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Controller.IController.IPanelManager;
import Architecture.Event.ClientEnterEvent;
import Architecture.Modle.IModle.IDataBaseModle;
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
        IDataBaseModle dBaseModle = this.GetModle(IDataBaseModle.class);

        if (dBaseModle.ClientContained(Name)) {
            inputMgr.PrintLine(PrintGrade.Error, "用户名已存在");
        } else {
            int id = dBaseModle.ClientAdd(Name, Password);
            if (id == -1) {
                inputMgr.PrintLine(PrintGrade.Error, "注册失败");
                return;
            }

            String Id = String.valueOf(id);
            this.SendEvent(new ClientEnterEvent(Id, Name));

            inputMgr.PrintLine(PrintGrade.Imforation, "客户注册成功");

            this.GetController(IPanelManager.class).ClosePanel();
            this.GetController(IPanelManager.class).OpenPanel(PanelType.ClientPanel);
        }
    }
}
