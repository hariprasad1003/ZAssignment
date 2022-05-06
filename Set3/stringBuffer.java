/*

Demonstrate the differences between String and StringBuffer classes.

Strings are immutable whereas StringBuffer are mutable.
Strings consumes more memory and slower whereas StringBuffer consumes low memory, performs faster.

*/

import java.util.Scanner;

public class stringBuffer{
    public static void main(String[] args){
        String string = "String are immutable ";
        System.out.println(string);

        StringBuffer stringBuffer=new StringBuffer("StringBuffer are ");
        stringBuffer.append("mutable");
        System.out.println(stringBuffer);

    }
}
