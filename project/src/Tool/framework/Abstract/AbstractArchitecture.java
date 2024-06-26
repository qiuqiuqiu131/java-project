package Tool.framework.Abstract;

import Tool.framework.IOCContainer;
import Tool.framework.Event.EventSystem;
import Tool.framework.Event.IEventListener;
import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.ICommand;
import Tool.framework.Interface.IController;
import Tool.framework.Interface.IModle;
import Tool.framework.Interface.IResCommand;

/**
 * 框架虚基类
 * 当需要设置一个项目的框架时必须继承自此基类
 * 同时,继承此基类的框架必须写成单例模式，方便View层获取框架对象
 * 
 * @author 洪秋阳
 */
public abstract class AbstractArchitecture implements IArchitecture {
    private boolean mInited = false;
    /* 控制反转容器 */
    private IOCContainer mContainer;
    /* 事件系统 */
    private EventSystem mEventSystem;

    protected AbstractArchitecture() {
        mEventSystem = new EventSystem();
        mContainer = new IOCContainer();
        Init();
        mContainer.Init();
        mInited = true;
    }

    /**
     * 虚函数,子类必须实现此初始化函数
     * 子类需要将框架中需要使用到的模块在这个函数中注册
     * 
     * 示例：
     * {@code
     * protected void Init(){
     *    this.RegisterController(IUIController.class,new UIController());
     *    this.RegisterModle(IClientModle.class,new ClientModle());
     * }
     * }
     */
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
        System.out.println(clz.getName());
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