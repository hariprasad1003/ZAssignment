abstract class A{
    abstract void func();
}

class B extends A{
    public void func(){
        System.out.println("This is func");
    }
}

public class abstractProg{
    public static void main(String[] args){
        B obj = new B();
        obj.func();
    }
}