/*

Write a program to find the number of occurrences of a sub string.

*/

public class noOfOccurenceSubstring{
    public static void main(String[] args){
        String string = "find the number of occurrences of a sub string";
        String subString= "of";
        int count = 0, index = 0;
        while ((index = string.indexOf(subString, index)) != -1 ){
            count++;
            index++;
        }

        System.out.println("Occurrences of a substring in the given string: " + count);
    }
}