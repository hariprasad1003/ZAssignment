/*

Learn exceptions Hierarchy and Types and demonstrate the different ways of handling Exceptions in Java.

Exceptions are categorized into two types

- User defined Exceptions
- Built-in Exceptions

Some of the Built-in Exceptions are ArithmeticException, ArrayIndexOutOfBoundsException, NumberFormatException..

*/


public class exceptions{

    /*

    Exception can be handled by using try and catch block.
    In catch block, we have to specify the Exception type 
    or we can also use general Exception alone
    */

    public static void tryCatch(){
        try{
            int x = 10;
            x = x / 0;
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
    }
    /*

    Multiple Exception can be handled by using Multiple Catch Blocks
    In Multiple Catch Exceptions, it should be ordered from Most specific to General
    */

    public static void tryMultipleCatch(){
        try{
            int array[] = {1, 2, 3, 4};
            array[5] = array[5] / 0;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /*

    Try block inside a try block is Nested try block,
    which used to handle the exception raised inside the try block 

    */

    public static void nestedTryBlock(){

        try{
            
            try{
                int x = 3 / 0;
            }
            catch(ArithmeticException e){
                System.out.println(e);
            }

            int array[] = {1, 2, 3, 4};
            array[5] = 0;

        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

    }

    /*

    After the exception is handled by catch block, 
    the code inside the block will be executed

    */

    public static void tryCatchFinally(){
        try{
            int y = 9;
            int z = 9 / 0;
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        finally{
            System.out.println("Finally Block is Executed");
        }
    }

    /*

    throw keyword is used to raise an exception,
    when it doesn't satisfy certain requirements.

    */

    public static void throwKeyword(int num){
        if(num < 0){
            throw new ArithmeticException("Negative Number");
        }
        else{
            System.out.println("Positive Number");
        }
    }

    public static void main(String[] args){
        // tryCatch();
        // tryMultipleCatch();
        // nestedTryBlock();
        // tryCatchFinally();
        // throwKeyword(-2);   
    }
}