package Tool.framework.Interface.Functional;

import Tool.framework.Interface.IUtility;

public interface IGetUtility extends IBelongToArchitecture {
    default <T extends IUtility> T GetUtility(Class<T> clz) {
        return this.GetArchitecture().GetUtility(clz);
    }
}
