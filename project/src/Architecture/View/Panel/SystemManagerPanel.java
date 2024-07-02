package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Command.SystemManage.ClientQueryCommand;
import Architecture.Command.SystemManage.FirmQueryCommand;
import Architecture.Command.SystemManage.SalerQueryCommand;

/**
 * 系统管理面板
 */
public class SystemManagerPanel extends BasePanel {
    public SystemManagerPanel() {
        super();

        panelName = "系统管理面板";
        commandList = new ArrayList<>(Arrays.asList(
                "客户查询",
                "销售员查询",
                "软件查询",
                "厂商查询"));
    }

    @SuppressWarnings("unused")
    private void Command1() {
        this.SendCommand(new ClientQueryCommand());
    }

    @SuppressWarnings("unused")
    private void Command2() {
        this.SendCommand(new SalerQueryCommand());
    }

    @SuppressWarnings("unused")
    private void Command3() {

    }

    @SuppressWarnings("unused")
    private void Command4() {
        this.SendCommand(new FirmQueryCommand());
    }
}
