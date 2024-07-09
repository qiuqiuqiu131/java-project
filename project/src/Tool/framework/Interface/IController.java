package Tool.framework.Interface;

import Tool.framework.Interface.Functional.ICanInit;
import Tool.framework.Interface.Functional.ICanRegisterEvent;
import Tool.framework.Interface.Functional.ICanSendCommand;
import Tool.framework.Interface.Functional.ICanSendEvent;
import Tool.framework.Interface.Functional.IGetController;
import Tool.framework.Interface.Functional.IGetModle;
import Tool.framework.Interface.Functional.IGetUtility;
import Tool.framework.Interface.Functional.ISetArchitecture;

/**
 * IController接口
 * 
 * @author 洪秋阳
 */
public interface IController
        extends ISetArchitecture, // 设置所处架构
        IGetController, // 允许获取控制器
        IGetModle, // 允许获取模型
        IGetUtility, // 允许获取工具
        ICanRegisterEvent, // 允许注册事件
        ICanSendEvent, // 允许发送事件
        ICanSendCommand, // 允许发送命令
        ICanInit {
}