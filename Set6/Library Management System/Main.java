import java.util.*;

public class Main{
    static Scanner sc = new Scanner(System.in);

    public static void listMemberChoices(){

        System.out.println("1. Search Books\n2. Exit");
        int choice;
        boolean loop = true;

        while(loop){
            choice = sc.nextInt();

            switch(choice){

                case 1:
                    // searchBooks();
                    break;
                case 2:
                    loop = false;
                    break;
                case 3:
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

        System.out.println("Welcome to Library Management System");
        while(loop){
            
            System.out.println("1. Member Signup \n2. Member Login\n3. Quit");
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