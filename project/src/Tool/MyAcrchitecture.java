package Tool;

import Manager.IInputManager;
import Manager.IPanelManager;
import Manager.InputManager;
import Manager.PanelManager;
import Tool.framework.AbstractArchitecture;

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
    }
}
