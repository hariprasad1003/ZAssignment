import java.util.*;

class Student1{
    public void getMarks(){
        System.out.println("Student 1's Maths Mark: " + 88);
    }
}

class Student2 extends Student1{
    public void getMarks(){
        System.out.println("Student 2's Maths Mark: " + 75);
    }
}

public class overriding{
    public static void main(String[] args){
        Student1 stu1 = new Student1();
        stu1.getMarks();
        Student2 stu2 = new Student2();
        stu2.getMarks();
    }
}