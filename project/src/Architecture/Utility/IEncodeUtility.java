package Architecture.Utility;

import Tool.framework.Interface.IUtility;

public interface IEncodeUtility extends IUtility {
    String encode(String pwd, String key);

    String decode(String pwd, String key);
}
