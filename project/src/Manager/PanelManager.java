package Manager;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Tool.framework.Abstract.AbstractController;
import View.PanelType;
import View.Panel.BasePanel;

public class PanelManager extends AbstractController implements IPanelManager {
    private Map<PanelType, BasePanel> panelDic;
    private Stack<PanelType> panelStack;

    public PanelManager() {
        // 初始化面板map
        panelDic = new HashMap<PanelType, BasePanel>();
        String panelPackName = BasePanel.class.getName().replace("BasePanel", "");
        for (PanelType panelType : PanelType.values()) {
            String clzName = panelPackName + panelType.toString();
            BasePanel panel;
            // 生成实例
            try {
                Class<?> clazz = Class.forName(clzName);
                Constructor<?> constructor = clazz.getConstructor();
                panel = (BasePanel) constructor.newInstance();
            } catch (Exception e) {
                continue;
            }
            // 添加实例
            panelDic.put(panelType, panel);
        }

        // 初始化面板栈
        panelStack = new Stack<PanelType>();
    }

    @Override
    protected void OnInit() {
        OpenPanel(PanelType.MainPanel);
    }

    @Override
    public void OpenPanel(PanelType type) {
        panelStack.push(type);
    }

    @Override
    public void ClosePanel() {
        panelStack.pop();
    }

    @Override
    public BasePanel CurrPanel() {
        return panelDic.get(panelStack.peek());
    }
}
