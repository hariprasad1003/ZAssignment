import java.util.*;

public class Main{
    static int loggedMember;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Checkout> checkOutList = new ArrayList<Checkout>();
    static ArrayList<Reserve> reserveList = new ArrayList<Reserve>();
    

    public static void checkOutOrReserve(){
        int bookUniNumber, bookFound = 0;
        String type = "";
        
        for(Member m : Member.memberList){
            if(m.memberId == loggedMember){
                if(m.checkOutCount < 5){
                    System.out.println("Enter the Unique Number of Book: ");
                    bookUniNumber = sc.nextInt();
                    for(Book b : Book.bookList){
                        if(b.uniNumber == bookUniNumber){
                            bookFound = 1;
                            if(b.noOfBookItems != 0){
                                type = "Checkout";
                                Checkout checkoutObj = new Checkout(m, b, type);
                                checkOutList.add(checkoutObj);
                                b.noOfBookItems -= 1;
                                m.checkOutCount += 1;

                                System.out.println("Book Checkout Successful");
                            }
                            else{
                                System.out.println("Book not Available, Do you want to Reserve the Book? (Y or N)");
                                char userChoice;
                                userChoice = sc.next().charAt(0);
                                if(userChoice == 'Y'){
                                    type="Reserve";
                                    Reserve reserveObj = new Reserve(m, b, type);
                                    reserveList.add(reserveObj);
                                }
                                System.out.println("Book Reserved Successfully");
                            }
                        }
                    }

                    if(bookFound == 0){
                        System.out.println("Book Not Found, Please Check the Book Unique Number");
                    }
                }
                else{
                    System.out.println("Checkout Limit Exceeded");
                }
            }
        }
    }

    public static void returnBook(){
        int bookUniNumber, isRemoved = 0;
        System.out.println("Enter the Unique Number of Book");
        bookUniNumber = sc.nextInt();
        // getCheckoutList();
        for(Iterator<Checkout> checkOutIterator = checkOutList.iterator(); checkOutIterator.hasNext();){
            Checkout c = checkOutIterator.next();
            if(c.member.memberId == loggedMember && c.book.uniNumber == bookUniNumber){
                c.book.noOfBookItems += 1;
                c.member.checkOutCount -= 1;
                checkOutIterator.remove();
                isRemoved = 1;
                System.out.println("Book Returned Succesfully");
            }
            else{
                System.out.println("Book not Checkedout by you");
            }
        }

        if(isRemoved == 1){
            for(Iterator<Reserve> reserveIterator = reserveList.iterator(); reserveIterator.hasNext();){
                Reserve r = reserveIterator.next();
                if(r.book.uniNumber == bookUniNumber){
                    Checkout corObj = new Checkout(r.member, r.book, "Checkout");
                    checkOutList.add(corObj);
                    r.book.noOfBookItems -= 1;
                    r.member.checkOutCount += 1;
                    reserveIterator.remove();
                    break;
                }
            }

            // for(int i = 0; i < reserveList.size(); i++) {
            //     Reserve r = reserveList.get(i);
            //     if(r.book.uniNumber == bookUniNumber){
            //         System.out.println(r.member.memberId + " " + loggedMember);
            //         Checkout corObj = new Checkout(r.member, r.book, "Checkout");
            //         checkOutList.add(corObj);
            //         r.book.noOfBookItems -= 1;
            //         r.member.checkOutCount += 1;
            //         reserveList.remove(i);
            //         break;
            //     }
            // };
        }
        // getCheckoutList();
    }


    public static void getCheckoutByMemeber(){
        int memberId;
        System.out.println("Checkout List by Specific Member");
        System.out.println("Enter the Member ID: ");
        memberId = sc.nextInt();

        if(checkOutList.isEmpty()){
            System.out.println("Empty List");
        }
        else{
            for(Checkout checkout : checkOutList){
                if(checkout.member.memberId == memberId){
                    System.out.println("\n--------------------------");
                    System.out.println("Checkout ID: " + checkout.checkOutId);
                    System.out.println("Member ID: " + checkout.member.memberId);
                    System.out.println("Member Name: " + checkout.member.name);
                    System.out.println("Book Unique Number: " + checkout.book.uniNumber);
                    System.out.println("Book Title: " + checkout.book.title);
                    System.out.println("Type: " + checkout.type);
                    System.out.println("Due Date: " + checkout.dueDate.getTime());

                    System.out.println("Member Checkout Count: " + checkout.member.checkOutCount);
                    System.out.println("Book Items Count: " + checkout.book.noOfBookItems);
                    System.out.println("--------------------------\n");        
                }
            }
        }
    }

    public static void getCheckoutList(){
        System.out.println("Checkout List");

        if(checkOutList.isEmpty()){
            System.out.println("Empty List");
        }
        else{
            for(Checkout checkout : checkOutList){
                System.out.println("\n--------------------------");
                System.out.println("Checkout ID: " + checkout.checkOutId);
                System.out.println("Member ID: " + checkout.member.memberId);
                System.out.println("Member Name: " + checkout.member.name);
                System.out.println("Book Unique Number: " + checkout.book.uniNumber);
                System.out.println("Book Title: " + checkout.book.title);
                System.out.println("Type: " + checkout.type);
                System.out.println("Due Date: " + checkout.dueDate.getTime());

                System.out.println("Member Checkout Count: " + checkout.member.checkOutCount);
                System.out.println("Book Items Count: " + checkout.book.noOfBookItems);
                System.out.println("--------------------------\n");        
            }

        }

    }

    public static void getReserveList(){
        System.out.println("Reserve List");
        
        if(reserveList.isEmpty()){
            System.out.println("Empty List");
        }
        else{
            for(Reserve reserve : reserveList){
                System.out.println("\n--------------------------");
                System.out.println("Member ID: " + reserve.member.memberId);
                System.out.println("Member Name: " + reserve.member.name);
                System.out.println("Book Unique Number: " + reserve.book.uniNumber);
                System.out.println("Book Title: " + reserve.book.title);
                System.out.println("Type: " + reserve.type);

                System.out.println("Member Checkout Count: " + reserve.member.checkOutCount);
                System.out.println("Book Items Count: " + reserve.book.noOfBookItems);
                System.out.println("--------------------------\n");        
            }
        }
    }

    public static void listMemberChoices(){

        int choice;
        boolean loop = true;

        while(loop){
            System.out.println("\n1. Search Books\n2. Checkout or Reserve Books\n3. Return Book\n4. Checkout List\n5. Checkout By Specific Member\n6. Exit\n");
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
                    returnBook();
                    break;
                case 4:
                    getCheckoutList();
                    getReserveList();
                    break;
                case 5:
                    getCheckoutByMemeber();
                    break;
                case 6:
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
        Book book3 = new Book("The Alchemist", "Paulo Coelho", "Quest,Adventure,Fantasy", "17 October 2005", 1, 1);
        Book book4 = new Book("To Kill a Mockingbird", "Harper Lee", "Thriller,Fiction", "11 July 1960", 2, 15);
        Book book5 = new Book("Good Vibes, Good Life", "Vex King", "Personal Development,Psychology,Nonfiction,Self Help", "20 January 2019", 2, 20);
        Book book6 = new Book("Gray Mountain", "John Grisham", "Thriller", "21 October 2014", 3, 10);
        Book book7 = new Book("As a Man Thinketh", "James Allen", "Self Help", "11 January 2006", 3, 30);

        Book.bookList.add(book1);
        Book.bookList.add(book2);
        Book.bookList.add(book3);
        Book.bookList.add(book4);
        Book.bookList.add(book5);
        Book.bookList.add(book6);
        Book.bookList.add(book7);

        
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