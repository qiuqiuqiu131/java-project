package View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Manager.IPanelManager;
import View.PanelType;

public class MainPanel extends BasePanel {
    public MainPanel() {
        panelName = "主界面";
        commandList = new ArrayList<>(Arrays.asList(
                "管理",
                "用户",
                "销售"));
    }

    @SuppressWarnings("unused")
    private void Command1() {
        System.out.println("\n切换到管理界面");
        this.GetController(IPanelManager.class).OpenPanel(PanelType.SystemManagerPanel);
    }

    @SuppressWarnings("unused")
    private void Command2() {
        System.out.println("\n切换到用户登录界面");
        this.GetController(IPanelManager.class).OpenPanel(PanelType.ClientLogPanel);
    }

    @SuppressWarnings("unused")
    private void Command3() {
        System.out.println("\n切换到销售登录界面");
        this.GetController(IPanelManager.class).OpenPanel(PanelType.SalerLogPanel);
    }

    public void Back() {
        System.exit(0);
    }
}
