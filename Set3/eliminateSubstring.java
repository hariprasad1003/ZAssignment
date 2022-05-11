/*

Write a program to eliminate a sub string from a string.

*/

public class eliminateSubstring {
    public static void main(String[] args)  {
        String string = "eliminate a sub string from a string";
        String subString = "from";
        String eliminate = string.replace(subString, "");

        System.out.println("Given String: " + string);
        System.out.println("String after Elimination of Substring: " + eliminate);
    }
}