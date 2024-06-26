package Architecture.Controller;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Architecture.Controller.IController.IInputManager;
import Architecture.Controller.IController.IPanelManager;
import Architecture.Event.StartEvent;
import Architecture.View.PanelType;
import Architecture.View.Panel.BasePanel;
import Tool.framework.Abstract.AbstractController;
import Tool.framework.Event.IEventListener;

/**
 * 面板控制器
 */
public class PanelManager
        extends AbstractController
        implements IPanelManager, IEventListener<StartEvent> {
    /* 储存面板枚举和面板实例的对应关系，方便存取 */
    private Map<PanelType, BasePanel> panelDic;

    private Map<PanelType, Class<?>> classDic;

    /* 储存了打开的面板的信息，采用栈的方式存取 */
    private Stack<PanelType> panelStack;

    public PanelManager() {
        /* 初始化面板类Map */
        classDic = new HashMap<PanelType, Class<?>>();
        /* 初始化面板Map ,使用反射的方式,将通过枚举获取对应的面板类，并实例化 */
        String panelPackName = BasePanel.class.getName().replace("BasePanel", "");
        for (PanelType panelType : PanelType.values()) {
            String clzName = panelPackName + panelType.toString();
            // 生成实例
            try {
                Class<?> clazz = Class.forName(clzName);
                classDic.put(panelType, clazz);
            } catch (Exception e) {
                continue;
            }
        }

        /* 初始化面板Map */
        panelDic = new HashMap<PanelType, BasePanel>();

        /* 初始化面板栈 */
        panelStack = new Stack<PanelType>();
    }

    @Override
    protected void OnInit() {
        this.RegisterEvent(StartEvent.class, this);
    }

    /**
     * 程序启动事件
     * 
     * @param obj
     */
    @Override
    public void Invoke(StartEvent obj) {
        for (PanelType panelType : PanelType.values()) {
            getPanel(panelType);
        }

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
        return getPanel(panelStack.peek());
    }

    private BasePanel getPanel(PanelType type) {
        if (panelDic.containsKey(type))
            return panelDic.get(type);
        if (classDic.containsKey(type)) {
            Class<?> clz = classDic.get(type);
            try {
                Constructor<?> constructor = clz.getConstructor();
                BasePanel panel = (BasePanel) constructor.newInstance();
                panelDic.put(type, panel);
                return panel;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
