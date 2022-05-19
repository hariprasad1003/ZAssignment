import java.util.*;

public class Checkout{
    static int checkOutId;
    Member member;
    Book book;
    String type;
    Calendar dueDate = Calendar.getInstance();
    
    Checkout(Member member, Book book, String type){
        dueDate.add(Calendar.DATE, 30);
        this.checkOutId = this.checkOutId + 1;
        this.member = member;
        this.book = book;
        this.type = type;
    }
}