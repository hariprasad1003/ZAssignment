/*

Write a program to find the length of the given string.

*/

import java.util.Scanner;

public class stringLength{
    public static void main(String[] args){
        int i, stringlength = 0;
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Input String: ");
        input = sc.next();

        char[] inputArray = input.toCharArray();  
        for(char ch : inputArray){
            stringlength++;
        }

       System.out.print("Length of the given string is: ");
       System.out.println(stringlength);
    }
}