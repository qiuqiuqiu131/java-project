package Tool.framework.Interface;

public interface ICanSendCommand extends IBelongToArchitecture {
    default <T extends ICommand> void SendCommand(T com) {
        this.GetArchitecture().SendCommand(com);
    }

    default <T> void SendCommand(IResCommand<T> com) {
        this.GetArchitecture().SendCommand(com);
    }
}
