package Tool.framework.Interface;

public interface ICommand
        extends
        ISetArchitecture,
        IGetController,
        IGetModle,
        ICanSentEvent {
    void Execute();
}