package proxy;

/**
 * 目标对象
 */
public class RealObject implements AbstractObject{

    public void operation() {
        System.out.println("realObject method!");
    }
}
