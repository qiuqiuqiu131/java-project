package tool;

import java.util.HashMap;
import java.util.Map;

public class Events {
    private Map<Class<?>, IEventSource<?>> EventDic;

    public Events() {
        EventDic = new HashMap<Class<?>, IEventSource<?>>();
    }

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

    @SuppressWarnings("unchecked")
    public <T> void Unregister(Class<T> clz, IEventListener<T> listener) {
        if (EventDic.containsKey(clz)) {
            ((IEventSource<T>) EventDic.get(clz)).Unregister(listener);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void Trigger(Class<T> clz, T obj) {
        if (EventDic.containsKey(clz)) {
            ((IEventSource<T>) EventDic.get(clz)).Trigger(obj);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void Trigger(T obj) {
        Class<?> clz = obj.getClass();
        if (EventDic.containsKey(clz))
            ((IEventSource<T>) EventDic.get(clz)).Trigger(obj);
    }
}
