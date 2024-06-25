package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 客户面板
 */
public class ClientPanel extends BasePanel {
    public ClientPanel() {
        panelName = "客户界面";
        commandList = new ArrayList<>(Arrays.asList(
                "查询"));
    }

    @SuppressWarnings("unused")
    private void Command1() {

    }
}
