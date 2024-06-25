package Tool.framework.Event;

import java.util.HashMap;
import java.util.Map;

/**
 * 事件处理器
 * 用于处理多事件的订阅和发送
 * 
 * @author 洪秋阳
 */
public class Events {
    private Map<Class<?>, IEventSource<?>> EventDic;

    public Events() {
        EventDic = new HashMap<Class<?>, IEventSource<?>>();
    }

    /**
     * 订阅事件
     * 
     * @param <T>      订阅的事件类型泛型
     * @param clz      需要订阅的事件类型,需要自定义对应事件的事件类
     * @param listener 订阅事件的监听者
     */
    @SuppressWarnings("unchecked")
    public <T> void Register(Class<T> clz, IEventListener<T> listener) {
        if (EventDic.containsKey(clz)) {
            ((IEventSource<T>) EventDic.get(clz)).Register(listener);
        } else {
            Event<T> events = new Event<T>();
            events.Register(listener);
            EventDic.put(clz, events);
        }
    }

    /**
     * 取消事件订阅
     * 
     * @param <T>      订阅的事件类型泛型
     * @param clz      需要取消订阅的事件类型,需要自定义对应事件的事件类
     * @param listener 订阅事件的监听者
     */
    @SuppressWarnings("unchecked")
    public <T> void Unregister(Class<T> clz, IEventListener<T> listener) {
        if (EventDic.containsKey(clz)) {
            ((IEventSource<T>) EventDic.get(clz)).Unregister(listener);
        }
    }

    /**
     * 事件触发
     * 
     * @param <T> 订阅的事件类型泛型
     * @param clz 需要触发的事件类型,需要自定义对应事件的事件类
     * @param obj 触发事件的对应事件类对象
     */
    @SuppressWarnings("unchecked")
    public <T> void Trigger(Class<T> clz, T obj) {
        if (EventDic.containsKey(clz)) {
            ((IEventSource<T>) EventDic.get(clz)).Trigger(obj);
        }
    }

    /**
     * 事件触发
     * 
     * @param <T> 订阅的事件类型泛型
     * @param obj 触发事件的对应事件类对象
     */
    @SuppressWarnings("unchecked")
    public <T> void Trigger(T obj) {
        Class<?> clz = obj.getClass();
        if (EventDic.containsKey(clz))
            ((IEventSource<T>) EventDic.get(clz)).Trigger(obj);
    }
}
