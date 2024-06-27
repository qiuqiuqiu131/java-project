package Tool.framework.Event;

/**
 * 事件监听者接口
 * 
 * @author 洪秋阳
 */
public interface IEventListener<T> {

    /**
     * 触发监听者的对应事件行为
     * 
     * @param obj 触发事件时传入的事件信息,一般需要定义一个Class类作为对应事件的事件类，用于标记事件和传参
     */
    public void Invoke(T obj);
}
