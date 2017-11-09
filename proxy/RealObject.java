package proxy;

/**
 * 目标对象
 */
public class RealObject extends AbstractObject{

    @Override
    public void operation() {
        System.out.println("realObject operation!");
    }
}
