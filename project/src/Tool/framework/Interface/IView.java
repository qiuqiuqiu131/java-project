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
                IGetController, // 允许获取控制器
                ICanRegisterEvent, // 允许注册事件
                ICanSendCommand, // 允许发送事件
                IGetModle // 允许获取模型
{
}
