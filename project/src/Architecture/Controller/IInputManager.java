package Architecture.Controller;

import Tool.framework.Interface.IController;

public interface IInputManager extends IController {
    /* 输入 */
    public String GetInputLine();

    public String GetInput();

    /* 输出 */
    public void PrintLine(PrintGrade printGrade, String mess);

    public void Print(PrintGrade printGrade, String mess);

    default public void Space() {
        System.out.println("");
    }
}
