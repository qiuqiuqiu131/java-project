package View.Panel;

import java.lang.reflect.Method;
import java.util.List;

import Manager.PanelManager;

public class BasePanel {
    protected String panelName;
    protected List<String> commandList;

    /**
     * 用于面板的显示
     * 
     * @return 返回命令数量
     */
    public int ShowView() {
        System.out.println("");
        System.out.println("————————————————");
        System.out.println(panelName);
        int count = 0;
        for (String s : commandList) {
            count++;
            System.out.println(count + ". " + s);
        }
        count++;
        System.err.println(count + ". 返回");
        System.out.println("————————————————");
        return count;
    }

    /**
     * 用于执行面板的对应命令功能
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

    public void Back() {
        PanelManager.Instance().ClosePanel();
        System.out.println("\n返回");
    }
}
