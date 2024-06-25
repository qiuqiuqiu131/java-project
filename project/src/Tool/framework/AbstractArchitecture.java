package Tool.framework;

import Tool.framework.Event.Events;
import Tool.framework.Event.IEventListener;
import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.IController;
import Tool.framework.Interface.IModle;

public abstract class AbstractArchitecture implements IArchitecture {
    private boolean mInited = false;
    private IOCContainer mContainer;
    private Events mEvents;

    public AbstractArchitecture() {
        mEvents = new Events();
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
        mEvents.Trigger(clz, obj);
    }

    public <T> void SendEvent(T obj) {
        mEvents.Trigger(obj);
    }

    public <T> void RegisterEvent(Class<T> clz, IEventListener<T> listener) {
        mEvents.Register(clz, listener);
    }

    public <T> void UnRegisterEvent(Class<T> clz, IEventListener<T> listener) {
        mEvents.Unregister(clz, listener);
    }
}