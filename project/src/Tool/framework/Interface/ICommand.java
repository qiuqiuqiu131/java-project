package Tool.framework.Interface;

import Tool.framework.Interface.Functional.ICanSendEvent;
import Tool.framework.Interface.Functional.IGetController;
import Tool.framework.Interface.Functional.IGetModle;
import Tool.framework.Interface.Functional.ISetArchitecture;

/**
 * ICommand接口(无返回值命令)
 * 
 * @author 洪秋阳
 */
public interface ICommand
        extends
        ISetArchitecture,
        IGetController,
        IGetModle,
        ICanSendEvent {
    /**
     * 命令的执行函数
     */
    void Execute();
}