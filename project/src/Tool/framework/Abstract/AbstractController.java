package Tool.framework.Abstract;

import Tool.framework.Interface.IArchitecture;
import Tool.framework.Interface.IController;

/**
 * 控制器基类
 * 定义一个控制器时必须继承此基类
 * 
 * @author 洪秋阳
 */
public abstract class AbstractController implements IController {
    private IArchitecture mArchitexture;
    private boolean Initialized;

    @Override
    public void SetArcitecture(IArchitecture architexture) {
        mArchitexture = architexture;
    }

    @Override
    public IArchitecture GetArchitecture() {
        return mArchitexture;
    }

    @Override
    public boolean Initialize() {
        return Initialized;
    }

    @Override
    public void Init() {
        Initialized = true;
        OnInit();
    }

    @Override
    public void DeInit() {
        OnDeinit();
    }

    protected void OnDeinit() {
    };

    protected abstract void OnInit();

}
