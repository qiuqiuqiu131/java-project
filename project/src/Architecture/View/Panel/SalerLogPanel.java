package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Command.SalerLoginCommand;
import Architecture.Command.SalerRegisterCommand;
import Architecture.Controller.IInputManager;

/**
 * 销售员登录面板
 */
public class SalerLogPanel extends BasePanel {
    public SalerLogPanel() {
        panelName = "销售员登录界面";
        commandList = new ArrayList<>(Arrays.asList(
                "登录",
                "注册"));
    }

    @SuppressWarnings("unused")
    private void Command1() {
        String clientName;
        String clientPassword;

        IInputManager inputmgr = this.GetController(IInputManager.class);
        System.out.print("用户名: ");
        clientName = inputmgr.GetInputLine();
        System.out.print("密码: ");
        clientPassword = inputmgr.GetInputLine();

        this.SendCommand(new SalerLoginCommand(clientName, clientPassword));
    }

    @SuppressWarnings("unused")
    private void Command2() {
        String clientName;
        String clientPassword;

        IInputManager inputmgr = this.GetController(IInputManager.class);
        System.out.print("用户名: ");
        clientName = inputmgr.GetInputLine();
        System.out.print("密码: ");
        clientPassword = inputmgr.GetInputLine();

        this.SendCommand(new SalerRegisterCommand(clientName, clientPassword));
    }
}
