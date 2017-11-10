package proxy.practice;

/**
 * 杂志
 */
public class Magazine implements Borrowing{
    @Override
    public void borrow() {
        System.out.println("borrow magazine!");
    }
}
