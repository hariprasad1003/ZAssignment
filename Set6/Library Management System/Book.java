import java.util.*;
import java.util.Random;

public class Book{
    int uniNumber;
    String title;
    String author;
    String subjectCategory;
    String publicationDate;
    int rackNumber;
    int noOfBookItems;

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> bookList = new ArrayList<Book>();

    Book(String title, String author, String subjectCategory, String publicationDate, int rackNumber, int noOfBookItems){
        Random rnd = new Random();
        this.uniNumber = rnd.nextInt(999999);

        this.title = title;
        this.author = author;
        this.subjectCategory = subjectCategory;
        this.publicationDate = publicationDate;
        this.rackNumber = rackNumber;
        this.noOfBookItems = noOfBookItems;
    }


    public static void listBooks(){

        System.out.println("\nList Books");
        System.out.println("--------------------------");

        for(Book b : bookList){
            displayBookDetails(b);
        }
    }

    public static void displayBookDetails(Book book){

        System.out.println("\n--------------------------");
        System.out.println("Book Unique Number: " + book.uniNumber);
        System.out.println("Book Title: " + book.title);
        System.out.println("Author: " + book.author);
        System.out.println("Subject Category: " + book.subjectCategory);
        System.out.println("Publication Date: " + book.publicationDate);
        System.out.println("Rack Number: " + book.rackNumber);
        System.out.println("No Of Copies Left: " + book.noOfBookItems);
        System.out.println("--------------------------\n");
    }

    public static void searchBooks(){

        int choice;
        boolean loop = true;
        String searchQuery;

        while(loop){

            System.out.println("\nSearch by \n1. Title\n2. Author\n3. Subject Category\n4. Publication Date\n5. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            if(choice == 1){
                int result = 0;
                System.out.println("Enter the Title of the Book");
                searchQuery = sc.next();
                searchQuery += sc.nextLine();

                for(Book b : bookList){
                    if((b.title).equalsIgnoreCase(searchQuery)){
                        result = 1;
                        displayBookDetails(b);
                    }
                }

                if(result == 0){
                    System.out.println("No Results");
                }
            }
            else if(choice == 2){
                int result = 0;
                System.out.println("Enter the Author Name: ");
                searchQuery = sc.next();
                searchQuery += sc.nextLine();

                for(Book b : bookList){
                    if((b.author).equalsIgnoreCase(searchQuery)){
                        result = 1;
                        displayBookDetails(b);
                    }
                }

                if(result == 0){
                    System.out.println("No Results");
                }
            }
            else if(choice == 3){
                int result = 0;
                System.out.println("Enter the Subject Category: ");
                searchQuery = sc.next();
                searchQuery += sc.nextLine();
                
                for(Book b : bookList){
                    String[] subjectCategories=b.subjectCategory.split(",");
                    for(int i = 0; i < subjectCategories.length; i++){
                        if((subjectCategories[i]).equalsIgnoreCase(searchQuery)){
                            result = 1;
                            displayBookDetails(b);
                        }
                    }
                }

                if(result == 0){
                    System.out.println("No Results");
                }
            }
            else if(choice == 4){
                int result = 0;
                System.out.println("Enter Publication Category (eg. 10 March 2003 DD:MM:YY)");
                searchQuery = sc.next();
                searchQuery += sc.nextLine();
                
                for(Book b : bookList){
                    if((b.publicationDate).equalsIgnoreCase(searchQuery)){
                        result = 1;
                        displayBookDetails(b);
                    }
                }

                if(result == 0){
                    System.out.println("No Results");
                }
                
            }
            else if(choice == 5){
                loop = false;
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
    }
}