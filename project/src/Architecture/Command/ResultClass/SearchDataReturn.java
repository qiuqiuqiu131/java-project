package Architecture.Command.ResultClass;

import java.util.ArrayList;
import java.util.List;

import Tool.Database.Class.SoftwareData;

public class SearchDataReturn {
    public List<SoftwareData> list;

    public SearchDataReturn(){
        this.list=new ArrayList<SoftwareData>();
    }
}
