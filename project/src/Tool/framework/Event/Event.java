package Tool.framework.Event;

import java.util.LinkedList;
import java.util.List;

/**
 * 事件
 * 储存对应T事件的监听者,
 * 并在此事件发生时触发所有监听此事件的监听者的对应行为
 * 
 * @author 洪秋阳
 */
public class Event<T> implements IEventSource<T> {
    private List<IEventListener<T>> listenerList;

    public Event() {
        listenerList = new LinkedList<IEventListener<T>>();
    }

    @Override
    public void Trigger(T obj) {
        for (IEventListener<T> listener : listenerList)
            listener.Invoke(obj);
    }

    @Override
    public void Register(IEventListener<T> listener) {
        listenerList.add(listener);
    }

    @Override
    public void Unregister(IEventListener<T> listener) {
        listenerList.remove(listener);
    }

}
