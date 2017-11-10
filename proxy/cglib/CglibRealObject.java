package proxy.cglib;

/**
 * 目标对象，没有实现任何接口
 */
public class CglibRealObject {

    public void operation(){
        System.out.println("CglibRealObject not implements interface!");
    }
}
