/*

Demonstrate the possibility of using private constructors with programs.

*/

class pc{
    private pc(){
        System.out.println("This is a Private Constructor");
    }

    public static pc getpcClass() {
       return new pc();
    }
}

public class privateConstructor{
    public static void main(String[] args){
        pc pcobj = pc.getpcClass();
        
    }
}