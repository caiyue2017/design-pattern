package proxy.practice;

/**
 * 录像带
 */
public class Video implements Borrowing{
    @Override
    public void borrow() {
        System.out.println("borrow video!");
    }
}
