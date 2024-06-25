package Tool.framework.Interface.Functional;

import Tool.framework.Interface.IModle;

/**
 * 定义获取IModle接口
 * 继承自IBelongToArchitecture接口
 * 通过此接口,对象能够间接的通过框架获取IModle
 * 
 * @author 洪秋阳
 */
public interface IGetModle extends IBelongToArchitecture {
    /**
     * 通过获取框架间接的获取IModle接口
     * 
     * @param <T> 约束泛型,必须继承自IModle接口
     * @param clz 需要获取的IModle接口类型
     * @return IModle接口类型
     */
    default <T extends IModle> T GetModle(Class<T> clz) {
        return this.GetArchitecture().GetModle(clz);
    }
}