package Tool.framework.Interface;

import Tool.framework.Event.IEventListener;

public interface IArchitecture {
    /* 注册模块 */
    <T extends IController> void RegisterController(Class<T> clz, T obj);

    <T extends IModle> void RegisterModle(Class<T> clz, T obj);

    /* 获取模块 */
    <T extends IController> T GetController(Class<T> clz);

    <T extends IModle> T GetModle(Class<T> clz);

    /* 事件 */
    <T> void SendEvent(Class<T> clz, T obj);

    <T> void SendEvent(T obj);

    <T> void RegisterEvent(Class<T> clz, IEventListener<T> listener);

    <T> void UnRegisterEvent(Class<T> clz, IEventListener<T> listener);

    /* 命令 */
    <T extends ICommand> void SendCommand(T com);

    <T> T SendCommand(IResCommand<T> com);
}
