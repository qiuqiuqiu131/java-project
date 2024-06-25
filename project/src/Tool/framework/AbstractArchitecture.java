package Tool.framework;

import Tool.framework.Event.IEventListener;
import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.IController;
import Tool.framework.Interface.IModle;

public abstract class AbstractArchitecture implements IArchitecture {
    private boolean mInited = false;
    private IOCContainer mContainer;

    public AbstractArchitecture() {
        mContainer = new IOCContainer();
        Init();
        mContainer.Init();
        mInited = true;
    }

    protected abstract void Init();

    public void Deinit() {
        OnDeinit();
        mContainer.Deinit();
    }

    protected void OnDeinit() {
    }

    /* 模块注册 */
    public <T extends IController> void RegisterController(Class<T> clz, T obj) {
        obj.SetArcitecture(this);

        mContainer.Register(clz, obj);

        if (mInited) {
            obj.Init();
        }
    }

    public <T extends IModle> void RegisterModle(Class<T> clz, T obj) {
        obj.SetArcitecture(this);

        mContainer.Register(clz, obj);

        if (mInited) {
            obj.Init();
        }
    }

    public <T extends IController> T GetController(Class<T> clz) {
        return mContainer.Get(clz);
    }

    public <T extends IModle> T GetModle(Class<T> clz) {
        return mContainer.Get(clz);
    }

    /* 事件 */
    public <T> void SendEvent(Class<T> clz, T obj) {

    }

    public <T> void SendEvent(Class<T> clz) {

    }

    public <T> void RegisterEvent(Class<T> clz, IEventListener<T> listener) {

    }
}