public class overloading{
    public static String concatenateName(String firstName, String lastName){
        return firstName + " " + lastName;
    }
    public static String concatenateName(String firstName, String lastName, String initial){
        return concatenateName(firstName, lastName) + " " + initial;
    }
    public static void main(String[] args){

        String firstName = "Hari";
        String lastName = "Prasad";
        String initial = "G";
        System.out.println(concatenateName(firstName, lastName));
        System.out.println(concatenateName(firstName, lastName, initial));

    }
}