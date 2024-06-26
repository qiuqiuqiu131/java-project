package Architecture.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Architecture.Controller.IController.IInputManager;
import Tool.framework.Abstract.AbstractController;

/**
 * 控制台输入输出控制器
 */
public class InputManager extends AbstractController implements IInputManager {
    private Scanner scanner;
    private Map<PrintGrade, String> tips;

    public InputManager() {
        scanner = new Scanner(System.in);

        tips = new HashMap<PrintGrade, String>();
        tips.put(PrintGrade.Error, "错误: ");
        tips.put(PrintGrade.Execute, "执行: ");
        tips.put(PrintGrade.Imforation, "消息: ");
    }

    @Override
    protected void OnInit() {

    }

    @Override
    public String GetInputLine() {
        return scanner.nextLine();
    }

    @Override
    public String GetInput() {
        return scanner.next();
    }

    @Override
    public void PrintLine(PrintGrade printGrade, String mess) {
        Space();
        String res = tips.get(printGrade) + mess;
        System.out.println(res);
    }

    @Override
    public void Print(PrintGrade printGrade, String mess) {
        Space();
        String res = tips.get(printGrade) + mess;
        System.out.print(res);
    }

}