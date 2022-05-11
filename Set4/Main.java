/*

Learn the "main" method of class and demonstrate your learnings with programs.

public static void main(String[] args)

public keyword is an access specifier, which defines the main method is accessible by JVM
static keyword is used to define that the main method can be called without initializing the object.
void defines that the main method returns nothing.

String[] args is an array which holds the command line argument data.
*/

// Without public keyword, main method is not visible to JVM


public class Main {
    static void main(String[] args) {
        System.out.println("Hello World");
    }
}

/*
Error: Main method not found in class Main, please define the main method as:
   public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application
*/

// Without static keyword, main method is not callable


public class Main {
    public void main(String[] args) {
        System.out.println("Hello World");
    }
}

/*
Error: Main method is not static in class Main, please define the main method as:
   public static void main(String[] args)
*/


// Return type should declared in every method in Java

public class Main {
    public static main(String[] args) {
        System.out.println("Hello World");
    }
}

/*
Main.java:47: error: invalid method declaration; return type required
    public static main(String[] args) {
                  ^
1 error
*/
