package Tool.framework;

import Tool.framework.Event.EventSystem;
import Tool.framework.Event.IEventListener;
import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.ICommand;
import Tool.framework.Interface.IController;
import Tool.framework.Interface.IModle;
import Tool.framework.Interface.IResCommand;

public abstract class AbstractArchitecture implements IArchitecture {
    private boolean mInited = false;
    private IOCContainer mContainer;
    private EventSystem mEventSystem;

    public AbstractArchitecture() {
        mEventSystem = new EventSystem();
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
        mEventSystem.Send(clz, obj);
    }

    public <T> void SendEvent(T obj) {
        mEventSystem.Send(obj);
    }

    public <T> void RegisterEvent(Class<T> clz, IEventListener<T> listener) {
        mEventSystem.Register(clz, listener);
    }

    public <T> void UnRegisterEvent(Class<T> clz, IEventListener<T> listener) {
        mEventSystem.UnRegister(clz, listener);
    }

    /* 命令 */
    public <T extends ICommand> void SendCommand(T com) {
        com.SetArcitecture(this);
        com.Execute();
    }

    public <T> T SendCommand(IResCommand<T> com) {
        com.SetArcitecture(this);
        return com.Execute();
    }
}