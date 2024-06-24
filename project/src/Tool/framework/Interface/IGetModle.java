package Tool.framework.Interface;

public interface IGetModle extends IBelongToArchitecture {
    default <T extends IModle> T GetModle(Class<T> clz) {
        return this.GetArchitecture().GetModle(clz);
    }
}