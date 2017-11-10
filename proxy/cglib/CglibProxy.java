package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理
 */
public class CglibProxy implements MethodInterceptor{

    // 目标对象
    private Object target;

    // 目标对象注入
    public CglibProxy(Object target){
        this.target = target;
    }

    /**
     * 创建代理对象
     * @return
     */
    public Object getProxyInstance(){
        // 1. 工具类
        Enhancer en = new Enhancer();
        // 2. 设置父类
        en.setSuperclass(target.getClass());
        // 3. 设置回调函数
        en.setCallback(this);
        // 4. 创建子类（代理对象）
        return en.create();
    }

    /**
     * 代理对象执行的拦截器方法
     * @param obj
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before...");
        Object result = method.invoke(target,args);
        System.out.println("After...");
        return result;
    }
}
