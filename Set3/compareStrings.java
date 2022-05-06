/*

Write a program to compare two strings with and without ignoring the case.

*/

import java.util.Scanner;

public class compareStrings{
    public static int compare(char[] string1Array, char[] string2Array){

        int result = 1;

        for(int i = 0; i < string1Array.length; i++){
            if(string1Array[i] != string2Array[i]){
                result = 0;
            }
        }
        
        return result;

    }

    public static void main(String[] args){
        String string1, string2;
        int result;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Input String1: ");
        string1 = sc.next();
        System.out.println("Enter the Input String2: ");
        string2 = sc.next();

        char string1ArrayWithCase[] = string1.toCharArray();
        char string2ArrayWithCase[] = string2.toCharArray();
        result = compare(string1ArrayWithCase, string2ArrayWithCase);
        
        System.out.print("String with case - ");
        if(result == 1){
            System.out.println("String match");
        }else{
            System.out.println("String doesn't macch");
        }

        String string1Uppercase = string1.toUpperCase();
        String string2Uppercase = string2.toUpperCase();
        char string1ArrayWithoutCase[] = string1Uppercase.toCharArray();
        char string2ArrayWithoutCase[] = string2Uppercase.toCharArray();
        
        result = compare(string1ArrayWithoutCase, string2ArrayWithoutCase);
        System.out.print("String without case - ");
        if(result == 1){
            System.out.println("String match");
        }else{
            System.out.println("String doesn't mactch");
        }
    }
}