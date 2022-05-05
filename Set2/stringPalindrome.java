/*

Write a program to check if the given string is a Palindrome.

*/

import java.util.Scanner;

public class stringPalindrome{
    public static void main(String[] args){
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Input String: ");
        input = sc.next();

        int inputStringLength = input.length();

        // System.out.println(inputStringLength);

        int result = 1;

        for(int i = 0, j = inputStringLength - 1; i < inputStringLength / 2; i++, j--){
            if(input.charAt(i) != input.charAt(j)){
                result = 0;
            }
        }

        if(result == 1){
            System.out.println("Given String " + input + " is a Palindrome");
        }
        else{
            System.out.println("Given String " + input + " is not a Palindrome");
        }
    }
}