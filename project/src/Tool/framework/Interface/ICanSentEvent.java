package Tool.framework.Interface;

public interface ICanSentEvent extends IBelongToArchitecture {
    default <T> void SendEvent(Class<T> clz, T obj) {
        this.GetArchitecture().SendEvent(clz, obj);
    }

    default <T> void SendEvent(Class<T> clz) {
        this.GetArchitecture().SendEvent(clz);
    }
}
