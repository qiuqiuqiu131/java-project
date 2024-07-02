package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Command.Log.ClientLoginCommand;
import Architecture.Command.Log.ClientLogoutCommand;
import Architecture.Command.Log.ClientRegisterCommand;
import Architecture.Controller.IController.IInputManager;

/**
 * 客户登录面板
 */
public class ClientLogPanel extends BasePanel {
    public ClientLogPanel() {
        super();

        panelName = "客户登录界面";
        commandList = new ArrayList<>(Arrays.asList(
                "登录",
                "注册",
                "注销"));
    }

    /**
     * 用户登录
     */
    @SuppressWarnings("unused")
    private void Command1() {
        String clientName;
        String clientPassword;

        IInputManager inputmgr = this.GetController(IInputManager.class);
        System.out.print("用户名: ");
        clientName = inputmgr.GetInputLine();
        System.out.print("密码: ");
        clientPassword = inputmgr.GetInputLine();

        // 发送客户登录命令
        this.SendCommand(new ClientLoginCommand(clientName, clientPassword));
    }

    /**
     * 用户注册
     */
    @SuppressWarnings("unused")
    private void Command2() {
        String clientName;
        String clientPassword;

        IInputManager inputmgr = this.GetController(IInputManager.class);
        System.out.print("用户名: ");
        clientName = inputmgr.GetInputLine();
        while (clientName.length() == 0) {
            System.out.print("重新输入用户名: ");
            clientName = inputmgr.GetInputLine();
        }

        System.out.print("密码: ");
        clientPassword = inputmgr.GetInputLine();
        while (clientPassword.length() == 0) {
            System.out.print("重新输入密码: ");
            clientPassword = inputmgr.GetInputLine();
        }

        // 发送客户注册命令
        this.SendCommand(new ClientRegisterCommand(clientName, clientPassword));
    }

    @SuppressWarnings("unused")
    private void Command3() {
        String clientName;
        String clientPassword;

        IInputManager inputmgr = this.GetController(IInputManager.class);
        System.out.print("用户名: ");
        clientName = inputmgr.GetInputLine();
        while (clientName.length() == 0) {
            System.out.print("重新输入用户名: ");
            clientName = inputmgr.GetInputLine();
        }

        System.out.print("密码: ");
        clientPassword = inputmgr.GetInputLine();
        while (clientPassword.length() == 0) {
            System.out.print("重新输入密码: ");
            clientPassword = inputmgr.GetInputLine();
        }

        // 发送客户注销命令
        this.SendCommand(new ClientLogoutCommand(clientName, clientPassword));
    }
}
