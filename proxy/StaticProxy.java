package proxy;

/**
 * 静态代理
 */
public class StaticProxy implements AbstractObject{

    private RealObject realObject = new RealObject();

    public void operation() {
        System.out.println("Before...");
        realObject.operation();
        System.out.println("After...");
    }
}
