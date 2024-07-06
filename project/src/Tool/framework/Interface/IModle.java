package Tool.framework.Interface;

import Tool.framework.Interface.Functional.ICanInit;
import Tool.framework.Interface.Functional.ICanRegisterEvent;
import Tool.framework.Interface.Functional.ICanSendEvent;
import Tool.framework.Interface.Functional.IGetModle;
import Tool.framework.Interface.Functional.IGetUtility;
import Tool.framework.Interface.Functional.ISetArchitecture;

/**
 * IModle接口
 * 
 * @author 洪秋阳
 */
public interface IModle
                extends ISetArchitecture, // 设置所处架构
                IGetModle, // 允许获取模型
                ICanSendEvent, // 允许发送事件
                ICanRegisterEvent, // 允许注册事件
                IGetUtility, // 允许获取工具
                ICanInit {
}