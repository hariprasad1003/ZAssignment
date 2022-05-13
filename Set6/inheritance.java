class Parent{
    int x = 10;

    public int add(int x, int y){
        return x + y;
    }
}

class Child extends Parent{
    int y = 20;

}

public class inheritance{
    public static void main(String[] args){
        Child child = new Child();
        System.out.println(child.x);
        System.out.println(child.y);
        System.out.println(child.add(2, 5));
    }
}