package Tool.framework.Interface.Functional;

import Tool.framework.Interface.IArchitecture;

/**
 * 定义属于框架接口
 * 使用此接口后,对象能够使用框架的功能
 * 
 * @author 洪秋阳
 */
public interface IBelongToArchitecture {
    /**
     * 获取框架
     * 
     * @return 返回只用的框架接口
     */
    IArchitecture GetArchitecture();
}
