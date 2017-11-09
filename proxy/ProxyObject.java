package proxy;

/**
 * 代理对象
 */
public class ProxyObject extends AbstractObject{

    RealObject realObject = new RealObject();

    @Override
    public void operation() {
        System.out.println("before...");
        realObject.operation();
        System.out.println("after....");
    }
}
