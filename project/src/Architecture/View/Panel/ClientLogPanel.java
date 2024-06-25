package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Command.ClientLoginCommand;
import Architecture.Command.ClientRegisterCommand;
import Architecture.Controller.IInputManager;

public class ClientLogPanel extends BasePanel {
    public ClientLogPanel() {
        panelName = "客户登录界面";
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

        this.SendCommand(new ClientLoginCommand(clientName, clientPassword));
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

        this.SendCommand(new ClientRegisterCommand(clientName, clientPassword));
    }
}
