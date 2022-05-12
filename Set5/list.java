import java.util.List;
import java.util.ArrayList;

public class list{
    public static void main(String[] args){
        List<Integer> listInt = new ArrayList<Integer>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(2, 3);
        System.out.println(listInt);
        System.out.println("Remove 3 and Add 4");

        // Elements in the List is removed using Index

        listInt.remove(2);
        listInt.add(4);
        System.out.println(listInt);

        System.out.println("Replace 4 with 3");
        listInt.set(2, 3);
        System.out.println(listInt);
    }
}