/*

Demonstrate access specifiers with programs (public, private, protected) for classes, methods, and members.

Public Access Specifier can be accessed from inside and outside other classes.
Protected Access Specifier can be accessed only inside and through inheritance only.
Private Access Specifier can only be accessed inside the class and can't be accessed outside the class.

Class can be public but cannot be private or protected

*/

class subProas extends protectedAccessSpecifier{}


public class accessSpecifiers{
    public static void main(String[] args){
        publicAccessSpecifier pubas = new publicAccessSpecifier();
        pubas.getDetails();
        System.out.println(pubas.number);

        subProas sproas = new subProas();
        sproas.getDetails();
        System.out.println(sproas.number);

        privateAccessSpecifier prias = new privateAccessSpecifier();
        prias.getDetails();
        System.out.println(prias.number);
    }
}