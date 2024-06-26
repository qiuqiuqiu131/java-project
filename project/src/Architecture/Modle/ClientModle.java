package Architecture.Modle;

import Architecture.Event.ClientEnterEvent;
import Architecture.Modle.IModle.IClientModle;
import Tool.framework.Abstract.AbstractModle;
import Tool.framework.Event.IEventListener;

public class ClientModle
        extends AbstractModle
        implements IClientModle,
        IEventListener<ClientEnterEvent> {
    private String Id;
    private String Name;

    @Override
    public void Invoke(ClientEnterEvent obj) {
        Id = obj.Id;
        Name = obj.Name;
    }

    @Override
    protected void OnInit() {
        this.RegisterEvent(ClientEnterEvent.class, this);
    }

}
