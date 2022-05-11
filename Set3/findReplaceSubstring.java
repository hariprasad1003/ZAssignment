/*

Write a program to Find & Replace a sub string from a given string.

*/

public class findReplaceSubstring{
    public static void main(String[] args)  {
        String string = "Find & Replace a sub string from a given string";
        String subString = "given";
        String replaceSubstring = "original";
        String replace = string.replace(subString, replaceSubstring);

        System.out.println("Given String: " + string);
        System.out.println("String after Elimination of Substring: " + replace);
    }
}