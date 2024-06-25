package Manager;

import Tool.framework.Interface.IController;
import View.PanelType;
import View.Panel.BasePanel;

public interface IPanelManager extends IController {
    public void OpenPanel(PanelType type);

    public void ClosePanel();

    public BasePanel CurrPanel();
}