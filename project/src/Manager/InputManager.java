package Manager;

import java.util.Scanner;

public class InputManager {
    private static InputManager _instance;
    private Scanner scanner;

    public static InputManager Instance() {
        if (_instance == null)
            _instance = new InputManager();
        return _instance;
    }

    private InputManager() {
        scanner = new Scanner(System.in);
    }

    public String GetInputLine() {
        return scanner.nextLine();
    }

    public String GetInput() {
        return scanner.next();
    }
}
