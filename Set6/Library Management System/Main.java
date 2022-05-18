import java.util.*;

public class Main{
    static int loggedMember;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<COR> corList = new ArrayList<COR>();

    public static void checkOutOrReserve(){
        int bookUniNumber, bookFound = 0;
        String type = "";
        System.out.println("Enter the Unique Number of Book: ");
        bookUniNumber = sc.nextInt();

        for(Book b : Book.bookList){
            if(bookUniNumber == b.uniNumber){
                bookFound = 1;
                System.out.println("Enter the type whether want to Checkout or Reserve: (C or R)");
                type = sc.next();
                if(type.equalsIgnoreCase("C")){
                    type = "Checkout";
                    COR corObj = new COR(loggedMember, bookUniNumber, type);
                    corList.add(corObj);
                    b.noOfBookItems -= 1;
                    for(Member m : Member.memberList){
                        if(m.memberId == loggedMember){
                            m.checkOutCount += 1;
                        }
                    }
                    System.out.println("Book Checkout Successful");
                    
                }
                else if(type.equalsIgnoreCase("R")){
                    type = "Reserve";
                    COR corObj = new COR(loggedMember, bookUniNumber, type);
                    corList.add(corObj);
                    b.noOfBookItems -= 1;

                    System.out.println("Book Reserve Successful");
                }
            }
        }

        if(bookFound == 0){
            System.out.println("Book Not Found, Please Check the Book Unique Number");
        }

    }

    public static void getCheckoutOrReserveList(){
        System.out.println("Checkout or Reserver List");
        for(COR cor : corList){
            System.out.println("\n--------------------------");
            System.out.println("Member ID: " + cor.memberId);
            System.out.println("Book Unique Number: " + cor.bookUniNumber);
            System.out.println("Type: " + cor.type);
            System.out.println("--------------------------\n");        
        }
    }

    public static void listMemberChoices(){

        int choice;
        boolean loop = true;

        while(loop){
            System.out.println("\n1. Search Books\n2. Checkout or Reserve Books\n3. Checkout or Reserve List\n4. Exit\n");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){

                case 1:
                    Book.searchBooks();
                    break;
                case 2:
                    checkOutOrReserve();
                    break;
                case 3:
                    getCheckoutOrReserveList();
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;

            }
        }

    }

    public static void main(String[] args){

        int choice;
        boolean loop = true;

        Member member1 = new Member("Hari Prasad", "hari345");
        Member member2 = new Member("Gokul", "23gokuL");
        Member member3 = new Member("Krishnan", "Hkris65");

        Member.memberList.add(member1);
        Member.memberList.add(member2);
        Member.memberList.add(member3);

        Book book1 = new Book("Wish I Could Tell You", "Durjoy Datta","Fiction", "4 October 2019", 1, 10);
        Book book2 = new Book("The Monk Who Sold His Ferrari", "Robin Sharma", "Fiction", "25 September 2003", 1, 10);
        Book book3 = new Book("The Alchemist", "Paulo Coelho", "Quest,Adventure,Fantasy", "17 October 2005", 1, 5);

        Book.bookList.add(book1);
        Book.bookList.add(book2);
        Book.bookList.add(book3);

        System.out.println("Welcome to Library Management System");
        while(loop){
            System.out.println("\n1. Member Signup \n2. Member Login\n3. Quit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    Member.signupMember();
                    break;
                case 2:
                    Member.loginMember();
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}