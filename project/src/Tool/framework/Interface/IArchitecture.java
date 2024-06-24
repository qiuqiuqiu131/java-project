package Tool.framework.Interface;

public interface IArchitecture {
    <T extends IController> void RegisterController(Class<T> clz, T obj);

    <T extends IModle> void RegisterModle(Class<T> clz, T obj);

    <T extends IController> T GetController(Class<T> clz);

    <T extends IModle> T GetModle(Class<T> clz);
}
