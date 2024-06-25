package Tool.framework.Interface.Functional;

import Tool.framework.Interface.ICommand;
import Tool.framework.Interface.IResCommand;

/**
 * 定义发送命令接口
 * 继承自IBelongToArchitecture接口
 * 通过此接口,对象能够间接的调用框架来发送命令
 * 
 * @author 洪秋阳
 */
public interface ICanSendCommand extends IBelongToArchitecture {
    /**
     * 发送命令
     * 无返回值
     * 
     * @param <T> 约束命令必须继承自ICommand接口(无返回值接口)
     * @param com 命令实例
     */
    default <T extends ICommand> void SendCommand(T com) {
        this.GetArchitecture().SendCommand(com);
    }

    /**
     * 发送命令
     * 有返回值
     * 
     * @param <T> 返回值类型泛型
     * @param com 命令实例,使用IResCommand接口,返回值类型由泛型自定义
     */
    default <T> void SendCommand(IResCommand<T> com) {
        this.GetArchitecture().SendCommand(com);
    }
}
