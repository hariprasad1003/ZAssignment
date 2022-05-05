/*

Write a program to copy a string into another string.

*/

import java.util.Scanner;

public class copyString{
    public static void main(String[] args){
        int sinputLength;
        String input, copyString;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Input String: ");
        input = sc.next();
        sinputLength = input.length();

        char inputArray[] = input.toCharArray();
        char copyArray[] = new char[sinputLength];

        for(int i = 0; i < sinputLength; i++){
            copyArray[i] = inputArray[i];
            // System.out.println(copyArray[i]);
        }

        copyString = new String(copyArray);

        System.out.println("Original String: " +  input);
        System.out.println("Copy String: " + copyString);

    }
}