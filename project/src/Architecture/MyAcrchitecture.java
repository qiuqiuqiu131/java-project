package Architecture;

import Architecture.Controller.IInputManager;
import Architecture.Controller.IPanelManager;
import Architecture.Controller.InputManager;
import Architecture.Controller.PanelManager;
import Architecture.Modle.DataBaseModle;
import Architecture.Modle.IDataBaseModle;
import Tool.framework.Abstract.AbstractArchitecture;

public class MyAcrchitecture extends AbstractArchitecture {

    private static MyAcrchitecture _instance;

    public static MyAcrchitecture Instance() {
        if (_instance == null)
            _instance = new MyAcrchitecture();
        return _instance;
    }

    private MyAcrchitecture() {
        super();
    }

    @Override
    protected void Init() {
        this.RegisterController(IPanelManager.class, new PanelManager());
        this.RegisterController(IInputManager.class, new InputManager());
        this.RegisterModle(IDataBaseModle.class, new DataBaseModle());
    }
}
