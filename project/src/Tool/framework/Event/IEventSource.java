package Tool.framework.Event;

/**
 * 事件源接口
 * 
 * @author 洪秋阳
 */
public interface IEventSource<T> {

    /**
     * 事件触发
     * 
     * @param obj 触发事件时传入的事件信息,一般需要定义一个Class类作为对应事件的事件类，用于标记事件和传参
     */
    void Trigger(T obj);

    /**
     * 订阅事件
     * 
     * @param listener 需要订阅事件的监听者
     */
    void Register(IEventListener<T> listener);

    /**
     * 取消订阅
     * 
     * @param listener 需要解除订阅的监听者
     */
    void Unregister(IEventListener<T> listener);
}
