package Tool.framework.Interface.Functional;

/**
 * 定义发送事件接口
 * 继承自IBelongToArchitecture接口
 * 通过此接口,对象能够间接的调用框架来发送事件
 * 
 * @author 洪秋阳
 */
public interface ICanSendEvent extends IBelongToArchitecture {
    /**
     * 订阅事件
     * 
     * @param <T>      订阅的事件类型泛型
     * @param clz      需要订阅的事件类型,需要自定义对应事件的事件类
     * @param listener 订阅事件的监听者
     */
    default <T> void SendEvent(Class<T> clz, T obj) {
        this.GetArchitecture().SendEvent(clz, obj);
    }

    /**
     * 取消事件订阅
     * 
     * @param <T>      订阅的事件类型泛型
     * @param clz      需要取消订阅的事件类型,需要自定义对应事件的事件类
     * @param listener 订阅事件的监听者
     */
    default <T> void SendEvent(T obj) {
        this.GetArchitecture().SendEvent(obj);
    }
}