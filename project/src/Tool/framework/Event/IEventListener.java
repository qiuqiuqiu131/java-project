package tool;

public interface IEventListener<T> {
    public void Invoke(T obj);
}
