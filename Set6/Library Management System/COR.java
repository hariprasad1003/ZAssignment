public class COR{
    static int corId;
    int memberId;
    int bookUniNumber;
    String type;

    COR(int memberId, int bookUniNumber, String type){
        this.corId = this.corId + 1;
        this.memberId = memberId;
        this.bookUniNumber = bookUniNumber;
        this.type = type;
    }
}