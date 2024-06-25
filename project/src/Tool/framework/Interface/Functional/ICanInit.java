package Tool.framework.Interface.Functional;

/**
 * 定义能够初始化接口
 * 模块能够通过此接口,由框架自动对其初始化
 * 
 * @author 洪秋阳
 */
public interface ICanInit {
    boolean Initialize();

    /**
     * 一般模块中事件的订阅都会在此函数中实现
     */
    void Init();

    void DeInit();
}
