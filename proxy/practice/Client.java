package proxy.practice;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        // 新建借阅对象
        Borrowing magazineBorrow = (Borrowing) new BorrowingDynamicProxy().getProxy(new Magazine());
        Borrowing bookBorrow = (Borrowing) new BorrowingDynamicProxy().getProxy(new Book());
        Borrowing DVDBorrow = (Borrowing) new BorrowingDynamicProxy().getProxy(new DVD());
        Borrowing VideoBorrow = (Borrowing) new BorrowingDynamicProxy().getProxy(new Video());
        // 开始借阅
        magazineBorrow.borrow();
        bookBorrow.borrow();
        DVDBorrow.borrow();
        VideoBorrow.borrow();
        magazineBorrow.borrow();
        VideoBorrow.borrow();
    }
}
