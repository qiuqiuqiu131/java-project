package Tool.framework.Interface;

import Tool.framework.Event.IEventListener;

public interface ICanRegisterEvent extends IBelongToArchitecture {
    default <T> void RegisterEvent(Class<T> clz, IEventListener<T> listener) {
        this.GetArchitecture().RegisterEvent(clz, listener);
    }

    default <T> void UnRegisterEvent(Class<T> clz, IEventListener<T> listener) {
        this.GetArchitecture().UnRegisterEvent(clz, listener);
    }
}
