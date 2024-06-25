package Tool.framework.Interface;

import Tool.framework.Interface.Functional.ICanInit;
import Tool.framework.Interface.Functional.ICanRegisterEvent;
import Tool.framework.Interface.Functional.ICanSendCommand;
import Tool.framework.Interface.Functional.ICanSendEvent;
import Tool.framework.Interface.Functional.IGetController;
import Tool.framework.Interface.Functional.IGetModle;
import Tool.framework.Interface.Functional.ISetArchitecture;

/**
 * IController接口
 * 
 * @author 洪秋阳
 */
public interface IController
        extends ISetArchitecture,
        IGetController,
        IGetModle,
        ICanRegisterEvent,
        ICanSendEvent,
        ICanSendCommand,
        ICanInit {

}