package Architecture.Controller;

import Architecture.View.PanelType;
import Architecture.View.Panel.BasePanel;
import Tool.framework.Interface.IController;

public interface IPanelManager extends IController {
    public void OpenPanel(PanelType type);

    public void ClosePanel();

    public BasePanel CurrPanel();
}