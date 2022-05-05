/*

Write a program to check the input string for the number of uppercase characters, lowercase characters, digits and special characters.


*/

import java.util.Scanner;

public class characterCount{
    public static void main(String[] args){
        int inputLength;
        int upperCaseCharacters = 0, lowerCaseCharacters = 0, digits = 0, specialCharacters = 0;
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Input String: ");
        input = sc.next();
        inputLength = input.length();

        for (int i = 0; i < input.length(); i++) {
            System.out.print(input.charAt(i));
            int asciiOfCharacter = (int) input.charAt(i);

            if(asciiOfCharacter >= 65 && asciiOfCharacter <= 90){
                upperCaseCharacters++;
            }
            else if(asciiOfCharacter >= 97 && asciiOfCharacter <= 122){
                lowerCaseCharacters++;
            }
            else if(asciiOfCharacter >= 48 && asciiOfCharacter <= 57){
                digits++;
            }
            else{
                specialCharacters++;
            }
        }

        System.out.println("No of Uppercase Characters: " + upperCaseCharacters);
        System.out.println("No of Lowercase Characters: " + lowerCaseCharacters);
        System.out.println("No of Digits: " + digits);
        System.out.println("No of Special Characters: " + specialCharacters);

    }
}