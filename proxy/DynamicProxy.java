package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class DynamicProxy implements InvocationHandler{

    // 目标对象
    private Object target;

    public Object getProxy(Object obj){
        this.target = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before...");
        Object result = method.invoke(target,args);
        System.out.println("After...");
        return result;
    }
}
