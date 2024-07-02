package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Command.Client.ClientGetItemCommand;
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
                "查看订单",
                "购买软件",
                "查询软件"));
    }

    @Override
    protected void Init() {
        this.RegisterEvent(ClientEnterEvent.class, this);
    }

    @Override
    public void Invoke(ClientEnterEvent obj) {
        panelName = "客户界面 (" + obj.Name + ")";
    }

    @SuppressWarnings("unused")
    private void Command1() {
        this.SendCommand(new ClientGetItemCommand());
    }

    @SuppressWarnings("unused")
    private void Command2() {

    }

    @SuppressWarnings("unused")
    private void Command3() {

    }
}
