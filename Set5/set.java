import java.util.*;

public class set{

    public static void union(Set<Integer> set1, Set<Integer> set2){
        set2.addAll(set1);

        System.out.println("Union of Set1 and Set2");

        System.out.println(set2);

    }

    public static void intersection(Set<Integer> set1, Set<Integer> set2){
        set2.retainAll(set1);

        System.out.println("Intersection of Set1 and Set2");

        System.out.println(set2);
    }

    public static void difference(Set<Integer> set1, Set<Integer> set2){
        set2.removeAll(set1);

        System.out.println("Difference of Set1 and Set2");

        System.out.println(set2);
    }


    public static void main(String[] args){

        // Union

        Set<Integer> set1= new HashSet<Integer>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Set1");
        System.out.println(set1);

        Set<Integer> set2= new HashSet<Integer>();
        set2.add(5);
        set2.add(2);
        set2.add(8);
        System.out.println("Set2");
        System.out.println(set2);

        union(set1, set2);
        // intersection(set1, set2);
        // difference(set1, set2);
        
    }
}