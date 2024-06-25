package Tool.framework.Interface.Functional;

import Tool.framework.Interface.IController;

/**
 * 定义获取IController接口
 * 继承自IBelongToArchitecture接口
 * 通过此接口,对象能够间接的通过框架获取IController
 * 
 * @author 洪秋阳
 */
public interface IGetController extends IBelongToArchitecture {
    /**
     * 通过获取框架间接的获取IController接口
     * 
     * @param <T> 约束泛型,必须继承自IController接口
     * @param clz 需要获取的IController接口类型
     * @return IController接口类型
     */
    default <T extends IController> T GetController(Class<T> clz) {
        return this.GetArchitecture().GetController(clz);
    }
}