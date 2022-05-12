/*

Write custom exceptions.

*/

class UserDefinedException extends Exception{
    UserDefinedException(String str){
        super(str);
    }
}

public class customException{
    public static void main(String[] args){

        try{
            throw new UserDefinedException("This is Custom User Defined Exception");
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}