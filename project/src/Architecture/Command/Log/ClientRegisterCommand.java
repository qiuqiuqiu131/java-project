package Architecture.Command.Log;

import Architecture.Controller.PrintGrade;
import Architecture.Controller.IController.IInputManager;
import Architecture.Controller.IController.IPanelManager;
import Architecture.Event.ClientEnterEvent;
import Architecture.Modle.IModle.IDataBaseModle;
import Architecture.Utility.IEncodeUtility;
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
            // 密码加密
            String encodePwd = this.GetUtility(IEncodeUtility.class).encode(Password, "加密");
            try {
                dBaseModle.ClientAdd(Name, encodePwd);

                this.SendEvent(new ClientEnterEvent(Name));
                inputMgr.PrintLine(PrintGrade.Imforation, "客户注册成功");

                this.GetController(IPanelManager.class).ClosePanel();
                this.GetController(IPanelManager.class).OpenPanel(PanelType.ClientPanel);
            } catch (Exception e) {
                inputMgr.PrintLine(PrintGrade.Error, "注册失败");
            }
        }
    }
}
