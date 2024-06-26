package Tool.framework.Abstract;

import Architecture.MyAcrchitecture;
import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.IView;

/**
 * 视图基类
 * 定义一个视图时必须继承自此基类
 * 
 * @author 洪秋阳
 */
public abstract class AbstractView implements IView {
    @Override
    public IArchitecture GetArchitecture() {
        return MyAcrchitecture.Instance();
    }

    protected void OnDeinit() {
    };

    protected abstract void OnInit();
}