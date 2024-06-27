package Tool.framework.Interface;

import Tool.framework.Event.IEventListener;

/**
 * 框架接口
 * 定义了框架的基本功能
 * 
 * @author 洪秋阳
 */
public interface IArchitecture {

    /* 注册模块 */

    /**
     * 注册Controller
     * 
     * @param <T> 模块类型必须继承自IController接口
     * @param clz 模块类型
     * @param obj 模块实例
     */
    <T extends IController> void RegisterController(Class<T> clz, T obj);

    /**
     * 注册Modle
     * 
     * @param <T> 模块类型必须继承自IModle接口
     * @param clz 模块类型
     * @param obj 模块实例
     */
    <T extends IModle> void RegisterModle(Class<T> clz, T obj);

    /**
     * 注册Utility
     * 
     * @param <T> 模块类型必须继承自IUtility接口
     * @param clz 模块类型
     * @param obj 模块实例
     */
    <T extends IUtility> void RegisterUtility(Class<T> clz, T obj);

    /* 获取模块 */

    /**
     * 获取Controller
     * 
     * @param <T> 模块类型必须继承自IController接口
     * @param clz 模块类型
     * @return 模块实例
     */
    <T extends IController> T GetController(Class<T> clz);

    /**
     * 获取Modle
     * 
     * @param <T> 模块类型必须继承自IModle接口
     * @param clz 模块类型
     * @return 模块实例
     */
    <T extends IModle> T GetModle(Class<T> clz);

    /**
     * 获取Utility
     * 
     * @param <T> 模块类型必须继承自IUtility接口
     * @param clz 模块类型
     * @return 模块实例
     */
    <T extends IUtility> T GetUtility(Class<T> clz);

    /* 事件 */

    /**
     * 事件触发
     * 
     * @param <T> 订阅的事件类型泛型
     * @param clz 需要触发的事件类型,需要自定义对应事件的事件类
     * @param obj 触发事件的对应事件类对象
     */
    <T> void SendEvent(Class<T> clz, T obj);

    /**
     * 取消事件订阅
     * 
     * @param <T>      订阅的事件类型泛型
     * @param clz      需要取消订阅的事件类型,需要自定义对应事件的事件类
     * @param listener 订阅事件的监听者
     */
    <T> void SendEvent(T obj);

    /**
     * 订阅事件
     * 
     * @param <T>      订阅的事件类型泛型
     * @param clz      需要订阅的事件类型,需要自定义对应事件的事件类
     * @param listener 订阅事件的监听者
     */
    <T> void RegisterEvent(Class<T> clz, IEventListener<T> listener);

    /**
     * 取消事件订阅
     * 
     * @param <T>      订阅的事件类型泛型
     * @param clz      需要取消订阅的事件类型,需要自定义对应事件的事件类
     * @param listener 订阅事件的监听者
     */
    <T> void UnRegisterEvent(Class<T> clz, IEventListener<T> listener);

    /* 命令 */

    /**
     * 发送命令
     * 无返回值
     * 
     * @param <T> 约束命令必须继承自ICommand接口(无返回值接口)
     * @param com 命令实例
     */
    <T extends ICommand> void SendCommand(T com);

    /**
     * 发送命令
     * 有返回值
     * 
     * @param <T> 返回值类型泛型
     * @param com 命令实例,使用IResCommand接口,返回值类型由泛型自定义
     */
    <T> T SendCommand(IResCommand<T> com);
}
