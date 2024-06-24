package Tool.framework;

import java.util.HashMap;
import java.util.Map;

import Tool.framework.Interface.ICanInit;

public class IOCContainer {
    private Map<Class<?>, Object> mInstances = new HashMap<>();

    public <T> void Register(Class<T> clz, T instance) {
        mInstances.put(clz, instance);
    }

    public <T> T Get(Class<T> clz) {
        Object ins = mInstances.get(clz);
        if (clz.isInstance(ins))
            return clz.cast(ins);
        return null;
    }

    public void Deinit() {
        for (Object init : mInstances.values()) {
            if (init instanceof ICanInit)
                ((ICanInit) init).DeInit();
        }
        Clear();
    }

    public void Init() {
        for (Object init : mInstances.values()) {
            if (init instanceof ICanInit)
                ((ICanInit) init).Init();
        }
    }

    public void Clear() {
        mInstances.clear();
    }
}
