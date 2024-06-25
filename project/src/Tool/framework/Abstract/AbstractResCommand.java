package Tool.framework.Abstract;

import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.IResCommand;

public abstract class AbstractResCommand<T> implements IResCommand<T> {
    private IArchitecture mArchitecture;

    @Override
    public void SetArcitecture(IArchitecture architexture) {
        mArchitecture = architexture;
    }

    @Override
    public IArchitecture GetArchitecture() {
        return mArchitecture;
    }

    @Override
    public T Execute() {
        return OnExecute();
    }

    protected abstract T OnExecute();

}
