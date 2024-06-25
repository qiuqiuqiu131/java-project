package Tool.framework.Interface;

import Tool.framework.Interface.Functional.ICanRegisterEvent;
import Tool.framework.Interface.Functional.ICanSendCommand;
import Tool.framework.Interface.Functional.IGetController;
import Tool.framework.Interface.Functional.IGetModle;

/**
 * IView接口
 */
public interface IView
        extends
        IGetController,
        ICanRegisterEvent,
        ICanSendCommand,
        IGetModle {

}
