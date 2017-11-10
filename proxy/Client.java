package proxy;

import proxy.cglib.CglibProxy;
import proxy.cglib.CglibRealObject;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("------static proxy------");
        AbstractObject object = new StaticProxy();
        object.operation();
        System.out.println("------dynamic proxy------");
        object = (AbstractObject) new DynamicProxy().getProxy(new RealObject());
        object.operation();
        System.out.println("------cglib proxy------");
        CglibRealObject cObject = (CglibRealObject) new CglibProxy(new CglibRealObject()).getProxyInstance();
        cObject.operation();
    }
}
