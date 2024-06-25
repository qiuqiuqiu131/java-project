package Tool.framework.Abstract;

import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.IModle;

public abstract class AbstractModle implements IModle {
    private IArchitecture mArchitexture;
    private boolean Initialized;

    @Override
    public void SetArcitecture(IArchitecture architexture) {
        mArchitexture = architexture;
    }

    @Override
    public IArchitecture GetArchitecture() {
        return mArchitexture;
    }

    @Override
    public boolean Initialize() {
        return Initialized;
    }

    @Override
    public void Init() {
        Initialized = true;
    }

    @Override
    public void DeInit() {
        OnDeinit();
    }

    protected void OnDeinit() {
    };

    protected abstract void OnInit();

}
