package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Event.ClientEnterEvent;
import Tool.framework.Event.IEventListener;

/**
 * 客户面板
 */
public class ClientPanel
        extends BasePanel
        implements IEventListener<ClientEnterEvent> {
    public ClientPanel() {
        super();

        panelName = "客户界面";
        commandList = new ArrayList<>(Arrays.asList(
                "查询"));
    }

    @Override
    protected void Init() {
        this.RegisterEvent(ClientEnterEvent.class, this);
    }

    @SuppressWarnings("unused")
    private void Command1() {

    }

    @Override
    public void Invoke(ClientEnterEvent obj) {
        panelName = String.format("客户界面 (%s)", obj.Name);
    }
}
