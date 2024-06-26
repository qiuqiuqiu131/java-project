package Tool.framework.Interface.Functional;

import Tool.framework.Event.IEventListener;

/**
 * 定义注册事件接口
 * 继承自IBelongToArchitecture接口
 * 通过此接口,对象能够间接的调用框架来监听事件
 * 
 * @author 洪秋阳
 */
public interface ICanRegisterEvent extends IBelongToArchitecture {
    /**
     * 订阅事件
     * 
     * @param <T>      订阅的事件类型泛型
     * @param clz      需要订阅的事件类型,需要自定义对应事件的事件类
     * @param listener 订阅事件的监听者
     */
    default <T> void RegisterEvent(Class<T> clz, IEventListener<T> listener) {
        this.GetArchitecture().RegisterEvent(clz, listener);
        System.out.println("订阅事件");
    }

    /**
     * 取消事件订阅
     * 
     * @param <T>      订阅的事件类型泛型
     * @param clz      需要取消订阅的事件类型,需要自定义对应事件的事件类
     * @param listener 订阅事件的监听者
     */
    default <T> void UnRegisterEvent(Class<T> clz, IEventListener<T> listener) {
        this.GetArchitecture().UnRegisterEvent(clz, listener);
    }
}
