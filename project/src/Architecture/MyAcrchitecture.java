package Architecture;

import Architecture.Controller.IInputManager;
import Architecture.Controller.IPanelManager;
import Architecture.Controller.InputManager;
import Architecture.Controller.PanelManager;
import Architecture.Modle.ClientModle;
import Architecture.Modle.DataBaseModle;
import Architecture.Modle.IClientModle;
import Architecture.Modle.IDataBaseModle;
import Architecture.Modle.ISalerModle;
import Architecture.Modle.SalerModle;
import Tool.framework.Abstract.AbstractArchitecture;

/**
 * 此项目的框架
 */
public class MyAcrchitecture extends AbstractArchitecture {

    /* 单例实现 */
    private static MyAcrchitecture _instance = null;

    public static MyAcrchitecture Instance() {
        if (_instance == null) {
            System.out.print("fsd");
            _instance = new MyAcrchitecture();
        }
        return _instance;
    }

    protected MyAcrchitecture() {
        super();
    }

    @Override
    protected void Init() {
        /* 面板控制器 */
        this.RegisterController(IPanelManager.class, new PanelManager());
        /* 控制台输入输出控制器 */
        this.RegisterController(IInputManager.class, new InputManager());
        /* 数据库模型 */
        this.RegisterModle(IDataBaseModle.class, new DataBaseModle());
        /* 客户模型 */
        this.RegisterModle(IClientModle.class, new ClientModle());
        /* 销售员 */
        this.RegisterModle(ISalerModle.class, new SalerModle());
    }
}
