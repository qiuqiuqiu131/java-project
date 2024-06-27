package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 系统管理面板
 */
public class SystemManagerPanel extends BasePanel {
    public SystemManagerPanel() {
        super();

        panelName = "系统管理面板";
        commandList = new ArrayList<>(Arrays.asList("查询"));
    }

    @SuppressWarnings("unused")
    private void Command1() {

    }
}
