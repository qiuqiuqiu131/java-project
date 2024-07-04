package Architecture.View.Panel;

import java.util.ArrayList;
import java.util.Arrays;

import Architecture.Command.Client.ClientGetSoftwareByDescriptionCommand;
import Architecture.Command.Client.ClientGetSoftwareByFirmnameCommand;
import Architecture.Command.ResultClass.SearchDataReturn;
import Architecture.Controller.IController.IInputManager;

public class SearchSoftWarePanel extends BasePanel{
    public SearchSoftWarePanel() {
        super();
        panelName="软件查询界面";
        commandList = new ArrayList<>(Arrays.asList("软件功能","软件厂商"));
    }

    @SuppressWarnings("unused")
    private void Command1() {
        String description;

        IInputManager inputmgr=this.GetController(IInputManager.class);
        System.out.print("输入功能：");
        description=inputmgr.GetInputLine();

        SearchDataReturn temp=this.SendCommand(new ClientGetSoftwareByDescriptionCommand(description));
    }

    @SuppressWarnings("unused")
    private void Command2() {
        String firmname;

        IInputManager inputmgr=this.GetController(IInputManager.class);
        System.out.print("输入厂商：");
        firmname=inputmgr.GetInputLine();

        SearchDataReturn temp=this.SendCommand(new ClientGetSoftwareByFirmnameCommand(firmname));
    }
}