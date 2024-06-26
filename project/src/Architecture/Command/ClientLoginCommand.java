package Architecture.Command;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Controller.IController.IPanelManager;
import Architecture.Event.ClientEnterEvent;
import Architecture.Modle.IModle.IDataBaseModle;
import Architecture.View.PanelType;
import Tool.Database.Class.ClientData;
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
        IDataBaseModle dBaseModle = this.GetModle(IDataBaseModle.class);

        if (!dBaseModle.ClientContained(Name)) {
            inputMgr.PrintLine(PrintGrade.Error, "客户不存在,请先注册");
        } else {
            ClientData data = dBaseModle.GetClient(Name);

            if (data.Password == Password) {
                this.SendEvent(new ClientEnterEvent(data.ID, Name));

                inputMgr.PrintLine(PrintGrade.Imforation, "客户登录成功");

                this.GetController(IPanelManager.class).ClosePanel();
                this.GetController(IPanelManager.class).OpenPanel(PanelType.ClientPanel);
            } else {
                inputMgr.PrintLine(PrintGrade.Error, "密码错误");
            }
        }
    }
}
