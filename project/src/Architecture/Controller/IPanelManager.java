package Architecture.Controller;

import Architecture.View.PanelType;
import Architecture.View.Panel.BasePanel;
import Tool.framework.Interface.IController;

/**
 * 定义PanelManager的接口
 */
public interface IPanelManager extends IController {
    /**
     * 打开面板
     * 
     * @param type 打开的面板枚举
     */
    public void OpenPanel(PanelType type);

    /**
     * 关闭当前面板
     */
    public void ClosePanel();

    /**
     * 获取当前面板
     * 
     * @return
     */
    public BasePanel CurrPanel();
}