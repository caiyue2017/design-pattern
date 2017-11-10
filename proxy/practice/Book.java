package proxy.practice;

/**
 * 书籍
 */
public class Book implements Borrowing{
    @Override
    public void borrow() {
        System.out.println("book borrow!");
    }
}
