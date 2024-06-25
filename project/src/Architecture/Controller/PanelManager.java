package Architecture.Controller;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Architecture.View.PanelType;
import Architecture.View.Panel.BasePanel;
import Tool.framework.Abstract.AbstractController;

/**
 * 面板控制器
 */
public class PanelManager extends AbstractController implements IPanelManager {
    /* 储存面板枚举和面板实例的对应关系，方便存取 */
    private Map<PanelType, BasePanel> panelDic;

    /* 储存了打开的面板的信息，采用栈的方式存取 */
    private Stack<PanelType> panelStack;

    public PanelManager() {
        /* 初始化面板Map ,使用反射的方式,将通过枚举获取对应的面板类，并实例化 */
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

        /* 初始化面板栈 */
        panelStack = new Stack<PanelType>();
    }

    @Override
    protected void OnInit() {
        OpenPanel(PanelType.MainPanel);
    }

    @Override
    public void OpenPanel(PanelType type) {
        panelStack.push(type);

        String mess = "转到" + CurrPanel().panelName;
        this.GetController(IInputManager.class).PrintLine(PrintGrade.Execute, mess);
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
