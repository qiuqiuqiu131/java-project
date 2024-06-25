package Tool.framework.Event;

/**
 * 事件系统,可以生成事件对象，也可以使用静态对象
 * 在Events类的基础上封装了一层
 * 
 * @author 洪秋阳
 */
public class EventSystem {
    private Events mEvent;

    public static EventSystem Global = new EventSystem();

    public EventSystem() {
        mEvent = new Events();
    }

    public <T> void Send(T e) {
        mEvent.Trigger(e);
    }

    public <T> void Send(Class<T> clz, T e) {
        mEvent.Trigger(clz, e);
    }

    public <T> void Register(Class<T> clz, IEventListener<T> listener) {
        mEvent.Register(clz, listener);
    }

    public <T> void UnRegister(Class<T> clz, IEventListener<T> listener) {
        mEvent.Unregister(clz, listener);
    }
}
