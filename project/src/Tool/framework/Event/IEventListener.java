package Tool.framework.Event;

public interface IEventListener<T> {
    public void Invoke(T obj);
}
