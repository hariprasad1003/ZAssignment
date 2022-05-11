/*

Demonstrate the differences between the "==" operator and "equals" method.

== operator compares the references, if both of points to same then it will be true, otherwise false
equals method compares the content, if both of content is same, then it will be true, otherwise false

*/

public class equal{
    public static void main(String[] args){
        String name1 = "Hari";
        String name2 = new String("Hari");
        String name3 = "Hari";

        System.out.println(name1 == name2);
        System.out.println(name1 == name3);
        System.out.println(name1.equals(name3));
    }
}