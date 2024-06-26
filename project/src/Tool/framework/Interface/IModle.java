package Tool.framework.Interface;

import Tool.framework.Interface.Functional.ICanInit;
import Tool.framework.Interface.Functional.ICanRegisterEvent;
import Tool.framework.Interface.Functional.ICanSendEvent;
import Tool.framework.Interface.Functional.IGetModle;
import Tool.framework.Interface.Functional.ISetArchitecture;

/**
 * IModle接口
 * 
 * @author 洪秋阳
 */
public interface IModle
                extends ISetArchitecture,
                IGetModle,
                ICanSendEvent,
                ICanRegisterEvent,
                ICanInit {

}