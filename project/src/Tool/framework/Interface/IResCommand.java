package Tool.framework.Interface;

public interface IResCommand<TResult>
        extends
        ISetArchitecture,
        IGetController,
        IGetModle,
        ICanSentEvent {
    TResult Execute();
}
