package Manager;

import java.util.Scanner;

import Tool.framework.AbstractController;

public class InputManager extends AbstractController implements IInputManager {
    private Scanner scanner;

    public InputManager() {
        scanner = new Scanner(System.in);
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
}