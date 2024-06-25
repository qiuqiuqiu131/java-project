package Architecture.View.Panel;

import java.lang.reflect.Method;
import java.util.List;

import Architecture.Controller.IInputManager;
import Architecture.Controller.IPanelManager;
import Architecture.Controller.PrintGrade;
import Tool.framework.Abstract.AbstractView;

/**
 * 面板基类
 * 后续所有的面板都继承自此基类
 * 对于后续的面板类,只需要设置面板名称,面板功能(commandList)以及对应功能的函数
 * 
 * 功能函数的命名规则:
 * 1、当前有n个功能,就要对应的写n个功能函数
 * 2、如当前需要编写第2个功能的功能函数,那么函数的命名为"private void Command2(){}";
 */
public class BasePanel extends AbstractView {
    public String panelName;
    protected List<String> commandList;

    /**
     * 用于面板的显示
     * 
     * @return 返回命令数量
     */
    public int ShowView() {
        System.out.println("");
        System.out.println("**********");
        System.out.println(panelName);
        System.out.println("--------------------");
        int count = 0;
        for (String s : commandList) {
            count++;
            System.out.println(count + ". " + s);
        }
        count++;
        System.err.println(count + ". 返回");
        System.out.println("--------------------");
        return count;
    }

    /**
     * 用于执行面板的对应命令功能
     * 这里采用反射的方法获取子类中的命令
     * 
     * @param i 需要执行的命令号
     * @return 是否正确执行
     */
    public boolean Execute(int i) {
        if (i > commandList.size() + 1)
            return false;
        else if (i == commandList.size() + 1) {
            Back();
            return true;
        }

        // 使用反射的方法，获取类中的函数
        Class<?> c = this.getClass();
        Method[] methods = c.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().equals("Command" + i)) {
                method.setAccessible(true);
                try {
                    method.invoke(this, (Object[]) null);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 界面返回
     */
    protected void Back() {
        this.GetController(IInputManager.class).PrintLine(PrintGrade.Execute, "界面返回");
        this.GetController(IPanelManager.class).ClosePanel();
    }

    @Override
    protected void OnInit() {
    }
}
