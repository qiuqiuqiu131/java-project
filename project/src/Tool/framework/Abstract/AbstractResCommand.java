package Tool.framework.Abstract;

import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.IResCommand;

/**
 * 命令基类(有返回值)
 * 定义一个命令时必须继承自此基类
 * 
 * @author 洪秋阳
 */
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
