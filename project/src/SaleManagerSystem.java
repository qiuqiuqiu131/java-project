import Manager.InputManager;
import Manager.PanelManager;

public class SaleManagerSystem {
    public static void main(String[] args) throws Exception {
        InputManager inputmgr = InputManager.Instance();
        PanelManager panelmgr = PanelManager.Instance();

        while (true) {
            /* 显示当前界面 */
            int count;
            count = panelmgr.CurrPanel().ShowView();
            System.out.print("执行命令编号: ");

            /* 读取输入，判断执行 */
            while (true) {
                String input = inputmgr.GetInputLine();
                int commandIndex;
                try {
                    commandIndex = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.print("输入有误!!\n执行命令编号: ");
                    continue;
                }
                if (commandIndex > count || commandIndex <= 0)
                    System.out.print("输入有误!!\n执行命令编号: ");
                else {
                    panelmgr.CurrPanel().Execute(commandIndex);
                    break;
                }
            }

        }

    }
}
