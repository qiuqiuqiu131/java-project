package tool;

import java.util.LinkedList;
import java.util.List;

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
