import java.util.*;

public class Reserve{
    static int reserveId;
    Member member;
    Book book;
    String type;

    Reserve(Member member, Book book, String type){
        this.reserveId = this.reserveId + 1;
        this.member = member;
        this.book = book;
        this.type = type;
    }
}