/*

Demonstrate the life and scope of variables with programs.

Three types of Scope of Variable in Java

- Class Variable
- Local Variable
- Instance Variable

*/

/*
Class Variable

Class variable are variables declared inside the class can be accessed anywhere inside the class and,
accessing from outside class depends on the access specifier of the variable

*/

class classVariable{
    String name = "Hari";
    int age = 21;

    public void getDetails(){
        System.out.println(name + " " + age);
    }

}


/*
Local Variable

Local variable are variables declared inside the method or block,
it can be accessed only inside the block or method.

*/

class localVariable{
    public void setandGetValueOfX(){
        int x;
        x = 10;   
        System.out.println(x);
    }
}

/*
Instance Variable



*/

class instanceVariable{
    String name;
    int age;
    instanceVariable(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getDetails(){
        return this.name + " " + this.age;
    }
}


public class scopeOfVariable{
    public static void main(String[] args){
        classVariable clsobj = new classVariable();
        System.out.println("Class Variable");
        clsobj.getDetails();
        localVariable locobj = new localVariable();
        System.out.println("Local Variable");
        locobj.setandGetValueOfX();
        instanceVariable insobj = new instanceVariable("Hari", 21);
        System.out.println("Instance Variable");
        System.out.println(insobj.getDetails());
    }
}