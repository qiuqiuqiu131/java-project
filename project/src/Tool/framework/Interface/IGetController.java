package Tool.framework.Interface;

public interface IGetController extends IBelongToArchitecture {
    default <T extends IController> T GetController(Class<T> clz) {
        return this.GetArchitecture().GetController(clz);
    }
}