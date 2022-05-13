import java.util.*;

public class Member{
    private static int id = 0;
    int memberId;
    String name;
    String password;
    int maximumCheckOutLimit = 5;

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Member> memberList = new ArrayList<Member>();
    
    Member(String name, String password){
        this.id = this.id + 11011;
        this.memberId = this.id;
        this.name = name;
        this.password = password;
    }

    public static void listMembers(){

        System.out.println("\nList Members");
        System.out.println("--------------------------");

        for(Member m : memberList){
            System.out.println("Member ID: " + m.memberId);
            System.out.println("Member Name: " + m.name);
            System.out.println("Maximum Checkout Limit: " + m.maximumCheckOutLimit);
        }
        System.out.println("--------------------------\n");
    }

    public static void signupMember(){

        String name, password;
        System.out.println("Enter your Name: ");
        name = sc.next();
        System.out.println("Enter your Password: ");
        password = sc.next();

        Member memberobj = new Member(name, password);
        memberList.add(memberobj);

        // listMembers();

        System.out.println("Member Signup Successful");
    }

    public static void loginMember(){
        
        boolean memberFlag = false;
        int memberId;
        String password;
        System.out.println("Enter your Member ID: ");
        memberId = sc.nextInt();

        for(Member m : memberList){
            if(m.memberId == memberId){
                memberFlag = true;
                System.out.println("Enter your Password: ");
                password = sc.next();

                if(m.password.equals(password)){
                    System.out.println("Member Login Successful");
                    Main.listMemberChoices();

                }
                else{
                    System.out.println("Wrong Password");
                }
            }
        }

        if(!(memberFlag)){
            System.out.println("Member Not Found, Please Check your Member ID");
        }

    }
}