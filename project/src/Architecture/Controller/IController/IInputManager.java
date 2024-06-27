package Architecture.Controller.IController;

import Architecture.Controller.PrintGrade;
import Tool.framework.Interface.IController;

/**
 * 定义InputManager的接口
 */
public interface IInputManager extends IController {

    /* 输入 */

    /**
     * 获取行输入
     * 
     * @return 输入值
     */
    public String GetInputLine();

    /**
     * 获取空格输入
     * 
     * @return 输入值
     */
    public String GetInput();

    /* 输出 */

    /**
     * 输出行
     * 
     * @param printGrade 输出等级
     * @param mess       输出信息
     */
    public void PrintLine(PrintGrade printGrade, String mess);

    /**
     * 输出
     * 
     * @param printGrade 输出等级
     * @param mess       输出信息
     */
    public void Print(PrintGrade printGrade, String mess);

    /**
     * 输出空行
     */
    default public void Space() {
        System.out.println("");
    }
}
