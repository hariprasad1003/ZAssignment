import java.util.*;
import java.util.concurrent.TimeUnit;

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

    public static long getDaysLeftDueDate(Checkout c){
        System.out.println();

        Date dueDate = c.dueDate.getTime();
        System.out.println(dueDate);
        Calendar todayCal = Calendar.getInstance();
        todayCal.add(Calendar.DATE, 34);

        // 30 34 = 4
        Date todayDate = todayCal.getTime();

        long diffInMillies = dueDate.getTime() - todayDate.getTime();
        long daysLeft = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return daysLeft;
    }


    public static void returnBook(){
        int bookUniNumber, isRemoved = 0;
        long dueDaysLeft;
        System.out.println("Enter the Unique Number of Book");
        bookUniNumber = sc.nextInt();
        for(Iterator<Checkout> checkOutIterator = checkOutList.iterator(); checkOutIterator.hasNext();){
            Checkout c = checkOutIterator.next();
            if(c.member.memberId == loggedMember && c.book.uniNumber == bookUniNumber){
                dueDaysLeft = getDaysLeftDueDate(c);
                if(dueDaysLeft < 0){
                    c.member.fine += 30;
                    System.out.println("Collected "  + c.member.fine + "rs fine for books returned after due date");
                    System.out.println();
                }
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

        }
    }

    public static void getCheckoutDetailsforBook(){
        int bookUniNumber, isEmpty = 1, isFound = 0;
        System.out.println("Checkout Details for Specific Book");
        System.out.println("Enter the Unique Number of Book: ");
        bookUniNumber = sc.nextInt();

        for(Book book : Book.bookList){
            if(bookUniNumber == book.uniNumber){
                isFound = 1;
            }
        }

        if(isFound == 1){
            if(!(checkOutList.isEmpty())){
                for(Checkout checkout : checkOutList){
                    if(checkout.book.uniNumber == bookUniNumber){
                        isEmpty = 0;
                        System.out.println("\n--------------------------");
                        System.out.println("Book Unique Number: " + checkout.book.uniNumber);
                        System.out.println("Book Title: " + checkout.book.title);
                        System.out.println("Book Items Left: " + checkout.book.noOfBookItems);
                        System.out.println("Member ID: " + checkout.member.memberId);
                        System.out.println("Member Name: " + checkout.member.name);
                        // System.out.println("Type: " + checkout.type);
                        System.out.println("--------------------------\n");
                    }
                }

                if(isEmpty == 1){
                    System.out.println("Empty List");    
                }
            }

        }else{
            System.out.println("Book not found, Please check the Unique number of Book");
        }
    }

    public static void getCheckoutDetailsforMember(){
        int memberId, isEmpty = 1, isFound = 0;
        System.out.println("Checkout Details for Specific Member");
        System.out.println("Enter the Member ID: ");
        memberId = sc.nextInt();

        for(Member member : Member.memberList){
            if(memberId == member.memberId){
                isFound = 1;
            }
        }
        if(isFound == 1){
            if(!(checkOutList.isEmpty())){
                for(Checkout checkout : checkOutList){
                    if(checkout.member.memberId == memberId){
                        isEmpty = 0;
                        System.out.println("\n--------------------------");
                        System.out.println("Member ID: " + checkout.member.memberId);
                        System.out.println("Member Name: " + checkout.member.name);
                        System.out.println("Book Unique Number: " + checkout.book.uniNumber);
                        System.out.println("Book Title: " + checkout.book.title);
                        // System.out.println("Type: " + checkout.type);
                        System.out.println("Book Items Left: " + checkout.book.noOfBookItems);
                        System.out.println("--------------------------\n");        
                    }
                }

                if(isEmpty == 1){
                    System.out.println("Empty List");
                }
            }

        }else{
            System.out.println("Member not found, Please check the Member Id");
        }

    }

    public static void getCheckoutDetailsList(){
        int isEmpty = 1;
        System.out.println("Checkout List");

        if(!(checkOutList.isEmpty())){
            for(Checkout checkout : checkOutList){
                if(checkout.member.memberId == loggedMember){
                    isEmpty = 0;
                    System.out.println("\n--------------------------");
                    System.out.println("Checkout ID: " + checkout.checkOutId);
                    System.out.println("Member ID: " + checkout.member.memberId);
                    System.out.println("Member Name: " + checkout.member.name);
                    System.out.println("Book Unique Number: " + checkout.book.uniNumber);
                    System.out.println("Book Title: " + checkout.book.title);
                    System.out.println("Type: " + checkout.type);
                    System.out.println("Due Date: " + checkout.dueDate.getTime() + " Days Left: " + getDaysLeftDueDate(checkout));

                    System.out.println("Member Checkout Count: " + checkout.member.checkOutCount);
                    System.out.println("Book Items Left: " + checkout.book.noOfBookItems);
                    System.out.println("--------------------------\n");   
                }
            }

            if(isEmpty == 1){
                System.out.println("Empty List");    
            }

        }else{
            System.out.println("Empty List");   
        }

    }

    public static void getReserveDetailsList(){
        int isEmpty = 1;
        System.out.println("Reserve List");
        
        if(!(reserveList.isEmpty())){
            for(Reserve reserve : reserveList){
                if(reserve.member.memberId == loggedMember){
                    isEmpty = 0;
                    System.out.println("\n--------------------------");
                    System.out.println("Reserve ID: " + reserve.reserveId);
                    System.out.println("Member ID: " + reserve.member.memberId);
                    System.out.println("Member Name: " + reserve.member.name);
                    System.out.println("Book Unique Number: " + reserve.book.uniNumber);
                    System.out.println("Book Title: " + reserve.book.title);
                    // System.out.println("Type: " + reserve.type);
                    System.out.println("Member Checkout Count: " + reserve.member.checkOutCount);
                    System.out.println("Book Items Count: " + reserve.book.noOfBookItems);
                    System.out.println("--------------------------\n");
                }        
            }
            if(isEmpty == 1){
                System.out.println("Empty List");    
            }
        }
        else{
            System.out.println("Empty List");   
        }
    }

    public static void listMemberChoices(){

        int choice;
        boolean loop = true;

        while(loop){
            System.out.println("\n1. Search Books\n2. Checkout or Reserve Books\n3. Return Book\n4. Checkout Details List\n5. Checkout Details for Specific Book\n6. Checkout Details for Specific Member\n7. Exit\n");
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
                    getCheckoutDetailsList();
                    getReserveDetailsList();
                    break;
                case 5:
                    getCheckoutDetailsforBook();
                    break;
                case 6: 
                    getCheckoutDetailsforMember();
                    break;
                case 7:
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
        Book book5 = new Book("Good Vibes Good Life", "Vex King", "Personal Development,Psychology,Nonfiction,Self Help", "20 January 2019", 2, 20);
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