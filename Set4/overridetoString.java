/*

Override the toString method in a program.

*/

class Employee{
    int empId;
    String name;
    Employee(int empId, String name){
        this.empId = empId;
        this.name = name;
    }
    @Override
    public String toString() {
        return this.empId + " " + this.name;
    }
}
 
public class overridetoString{
    public static void main(String[] args) {
        Employee emp = new Employee(576, "Hari");
        System.out.println(emp.toString());
    }
}