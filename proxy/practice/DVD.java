package proxy.practice;

/**
 * DVD
 */
public class DVD implements Borrowing{
    @Override
    public void borrow() {
        System.out.println("borrow DVD!");
    }
}
