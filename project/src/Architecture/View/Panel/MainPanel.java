package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Controller.IPanelManager;
import Architecture.View.PanelType;

/**
 * 主面板
 */
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
        this.GetController(IPanelManager.class).OpenPanel(PanelType.SystemManagerPanel);
    }

    @SuppressWarnings("unused")
    private void Command2() {
        this.GetController(IPanelManager.class).OpenPanel(PanelType.ClientLogPanel);
    }

    @SuppressWarnings("unused")
    private void Command3() {
        this.GetController(IPanelManager.class).OpenPanel(PanelType.SalerLogPanel);
    }

    public void Back() {
        System.exit(0);
    }
}
