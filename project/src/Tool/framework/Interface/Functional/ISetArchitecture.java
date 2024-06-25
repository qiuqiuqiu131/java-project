package Tool.framework.Interface.Functional;

import Tool.framework.Interface.IArchitecture;

/**
 * 定义设置框架接口
 * 一般需要和IBelongToArchitecture配合使用
 * 
 * @author 洪秋阳
 */
public interface ISetArchitecture {
    /**
     * 设置所属的框架
     * 
     * @param architexture 框架接口对象
     */
    void SetArcitecture(IArchitecture architexture);
}