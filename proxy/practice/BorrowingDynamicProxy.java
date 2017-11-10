package proxy.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态计数代理
 */
public class BorrowingDynamicProxy implements InvocationHandler{

    // 计数器
    private int counter;

    private Object target;

    public Object getProxy(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target,args);
        System.out.println("当前借阅数："+(++counter));
        return result;
    }
}
