/*

Demonstrate with programs for the primitive data types, arrays, String and user defined data types whether parameters are passed by value or reference.

*/

class Student{
    String name;
    int age;
    boolean isPresent;
    Student(String name, int age, boolean isPresent){
        this.name = name;
        this.age = age;
        this.isPresent = isPresent;
    }
}

public class dataTypes{

    public static void passByValue(int a){
        a++;
    }

    public static void main(String[] args){
        
        // Primitive Data Types in Java are byte, short, int, long, char, float, double, boolean

        byte numberOfStudents = 110;    // ranges from -2^7 to 2^7 - 1
        short numberOfPeopleInChennai = 20000;  // ranges from -2^15 to 2^15 - 1
        int numberOfPeopleInTamilNadu = 10000000;   // ranges from -2^31 to 2^31 - 1
        long numberOfPeopleInIndia = 2000000000;    // ranges from -2^63 to 2^63 - 1
        char letter = 'a';  // ranges from 0 to 2^16 - 1
        float mathsMark = 87.53243678f;    // stores in 32 bits of memory
        double decimal = 98.1345759992338476;   // stores in 64 bits of memory
        boolean isAdmin = true; // true or false


        // Non Primitive Data Types in Java are Arrays, Strings, User defined Data types..

        // Arrays

        int array[] = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

        // Strings

        String string = "Hello World";
        System.out.println(string);

        // User Defined Data Types

        // Using classes, we can able to create user defined data types

        Student student = new Student("Hari Prasad", 21, true);
        System.out.println(student.name);

        // Parameters are passed by value in java

        // Here we are passing a integer 'a' to passByValue method, 
        // value of a is increment in the method,
        // but still the increment value of a is not refelected in main method

        int a = 10;
        passByValue(a);
        System.out.println(a);


    }
}