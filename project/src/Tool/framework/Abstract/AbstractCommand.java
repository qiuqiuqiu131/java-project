package Tool.framework.Abstract;

import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.ICommand;

/**
 * 命令基类(无返回值)
 * 定义一个命令时必须继承自此基类
 * 
 * @author 洪秋阳
 */
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
