package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Command.SalerLoginCommand;
import Architecture.Command.SalerLogoutCommand;
import Architecture.Command.SalerRegisterCommand;
import Architecture.Controller.IController.IInputManager;

/**
 * 销售员登录面板
 */
public class SalerLogPanel extends BasePanel {
    public SalerLogPanel() {
        super();

        panelName = "销售员登录界面";
        commandList = new ArrayList<>(Arrays.asList(
                "登录",
                "注册"));
    }

    @SuppressWarnings("unused")
    private void Command1() {
        String salerName;
        String salerPassword;

        IInputManager inputmgr = this.GetController(IInputManager.class);
        System.out.print("用户名: ");
        salerName = inputmgr.GetInputLine();
        System.out.print("密码: ");
        salerPassword = inputmgr.GetInputLine();

        // 发送销售员登录命令
        this.SendCommand(new SalerLoginCommand(salerName, salerPassword));
    }

    @SuppressWarnings("unused")
    private void Command2() {
        String salerName;
        String salerPassword;

        IInputManager inputmgr = this.GetController(IInputManager.class);
        System.out.print("用户名: ");
        salerName = inputmgr.GetInputLine();
        while (salerName.length() == 0) {
            System.out.println("重新输入用户名: ");
            salerName = inputmgr.GetInputLine();
        }

        System.out.print("密码: ");
        salerPassword = inputmgr.GetInputLine();
        while (salerPassword.length() == 0) {
            System.out.print("重新输入密码: ");
            salerPassword = inputmgr.GetInputLine();
        }

        // 发送销售员注册命令
        this.SendCommand(new SalerRegisterCommand(salerName, salerPassword));
    }

    @SuppressWarnings("unused")
    private void Command3() {
        String salerName;
        String salerPassword;

        IInputManager inputmgr = this.GetController(IInputManager.class);
        System.out.print("用户名: ");
        salerName = inputmgr.GetInputLine();
        while (salerName.length() == 0) {
            System.out.print("重新输入用户名: ");
            salerName = inputmgr.GetInputLine();
        }

        System.out.print("密码: ");
        salerPassword = inputmgr.GetInputLine();
        while (salerPassword.length() == 0) {
            System.out.print("重新输入密码: ");
            salerPassword = inputmgr.GetInputLine();
        }

        // 发送销售员注销命令
        this.SendCommand(new SalerLogoutCommand(salerName, salerPassword));
    }
}
