package Tool.framework.Abstract;

import Tool.MyAcrchitecture;
import Tool.framework.Interface.IView;

public abstract class AbstractView implements IView {
    @Override
    public AbstractArchitecture GetArchitecture() {
        return MyAcrchitecture.Instance();
    }

    protected void OnDeinit() {
    };

    protected abstract void OnInit();
}