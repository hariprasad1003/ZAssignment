import java.io.*;

interface Interface{
    void printMessage();
}

class sampleClass implements Interface{
    public void printMessage(){
        System.out.println("Hello World");
    }
}

public class interfaceProg{
    public static void main(String[] args){
        sampleClass sacl = new sampleClass();
        sacl.printMessage();
    }
}