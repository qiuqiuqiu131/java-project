package View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Manager.IInputManager;
import Manager.IPanelManager;
import View.PanelType;

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

        /*
         * TODO:
         * 发送登录请求
         */

        // 假如成功
        System.out.println("\n登录成功");
        System.out.println("切换到用户界面");
        this.GetController(IPanelManager.class).ClosePanel();
        this.GetController(IPanelManager.class).OpenPanel(PanelType.SalerPanel);
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

        /*
         * TODO:
         * 发送注册请求
         */

        // 假如成功
        System.out.println("\n注册成功");
        System.out.println("切换到销售员界面");
        this.GetController(IPanelManager.class).ClosePanel();
        this.GetController(IPanelManager.class).OpenPanel(PanelType.SalerPanel);
    }
}