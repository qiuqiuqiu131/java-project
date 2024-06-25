package Tool.framework;

import java.util.HashMap;
import java.util.Map;

import Tool.framework.Interface.Functional.ICanInit;

/**
 * 控制反转容器
 * 用于储存框架中模块,将模块的实际控制权交给框架实现
 * 
 * @author 洪秋阳
 */
public class IOCContainer {
    /* 模块存储Map ,将Class<?> 作为key值 ,Object 作为Value */
    private Map<Class<?>, Object> mInstances = new HashMap<>();

    /**
     * 注册模块
     * 
     * @param <T>      模块类泛型
     * @param clz      模块类型
     * @param instance 需要注册的模块实例
     */
    public <T> void Register(Class<T> clz, T instance) {
        mInstances.put(clz, instance);
    }

    /**
     * 获取模块
     * 
     * @param <T> 模块类泛型
     * @param clz 模块类型
     * @return 返回容器中对应类型的模块实例
     */
    public <T> T Get(Class<T> clz) {
        Object ins = mInstances.get(clz);
        if (clz.isInstance(ins))
            return clz.cast(ins);
        return null;
    }

    /**
     * 对于当前容器中的所有模块,通过其ICanInit接口进行销毁
     */
    public void Deinit() {
        for (Object init : mInstances.values()) {
            if (init instanceof ICanInit)
                ((ICanInit) init).DeInit();
        }
        Clear();
    }

    /**
     * 对于当前容器中的所有模块,通过其ICanInit接口进行初始化
     */
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
