package Tool.framework.Abstract;

import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.ICommand;

public abstract class AbstractCommand implements ICommand {
    private IArchitecture mArchitecture;

    public void SetArcitecture(IArchitecture architexture) {
        mArchitecture = architexture;
    }

    public IArchitecture GetArchitecture() {
        return mArchitecture;
    }

    public void Execute() {
        OnExecute();
    }

    protected abstract void OnExecute();
}
