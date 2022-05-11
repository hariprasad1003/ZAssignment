/*

Demonstrate the usage of static methods with programs.

Using static keyword, we can able to access it without initializing the class

*/

class staticExampleClass{
    private static int number = 10;
    public static int getNumber(){
        return number;
    }
}

public class staticMethod{
    public static void main(String[] args){
        System.out.println(staticExampleClass.getNumber());
    }
}