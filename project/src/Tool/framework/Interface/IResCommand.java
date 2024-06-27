package Tool.framework.Interface;

import Tool.framework.Interface.Functional.ICanSendEvent;
import Tool.framework.Interface.Functional.IGetController;
import Tool.framework.Interface.Functional.IGetModle;
import Tool.framework.Interface.Functional.IGetUtility;
import Tool.framework.Interface.Functional.ISetArchitecture;

/**
 * IResCommand接口(有返回值命令)
 */
public interface IResCommand<TResult>
        extends
        ISetArchitecture,
        IGetController,
        IGetModle,
        IGetUtility,
        ICanSendEvent {
    /**
     * 执行函数
     * 
     * @return 返回值
     */
    TResult Execute();
}
