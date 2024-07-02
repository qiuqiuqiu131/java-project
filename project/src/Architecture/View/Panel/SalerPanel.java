package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Command.Saler.SalerGetItemCommand;
import Architecture.Event.SalerEnterEvent;
import Tool.framework.Event.IEventListener;

/**
 * 销售员面板
 */
public class SalerPanel
        extends BasePanel
        implements IEventListener<SalerEnterEvent> {
    public SalerPanel() {
        super();

        panelName = "销售员界面";
        commandList = new ArrayList<>(Arrays.asList("查询"));
    }

    @Override
    public void Init() {
        this.RegisterEvent(SalerEnterEvent.class, this);
    }

    @Override
    public void Invoke(SalerEnterEvent obj) {
        panelName = "销售员界面 (" + obj.Name + ")";
    }

    @SuppressWarnings("unused")
    private void Command1() {
        this.SendCommand(new SalerGetItemCommand());
    }
}
