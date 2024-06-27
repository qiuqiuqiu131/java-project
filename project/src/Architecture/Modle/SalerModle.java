package Architecture.Modle;

import Architecture.Event.SalerEnterEvent;
import Architecture.Modle.IModle.ISalerModle;
import Tool.framework.Abstract.AbstractModle;
import Tool.framework.Event.IEventListener;

public class SalerModle extends AbstractModle
        implements ISalerModle,
        IEventListener<SalerEnterEvent> {
    private String Name;

    @Override
    protected void OnInit() {
        this.RegisterEvent(SalerEnterEvent.class, this);
    }

    @Override
    public void Invoke(SalerEnterEvent obj) {
        Name = obj.Name;
    }

}
