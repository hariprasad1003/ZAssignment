/*

Write a program to concatenate two strings.

*/

import java.util.Scanner;

public class concatenateStrings{
    public static void main(String[] args){
        String input1, input2, result;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Input String1: ");
        input1 = sc.next();
        System.out.println("Enter the Input String2: ");
        input2 = sc.next();

        result = input1 + input2;
        System.out.println("Concatenated Strings: " + result);

    }
}