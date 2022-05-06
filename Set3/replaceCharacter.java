/*

Write a program to replace a character with a given character in a string.

*/


import java.util.Scanner;

class replaceCharacter {
	public static void main(String args[])
	{

		String string;
        char character, replaceChar;
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Input String: ");
        string = sc.next();
        System.out.println("Enter the Character to be replaced: ");
        character = sc.next().charAt(0);
        System.out.println("Enter the Character to be replaced by: ");
        replaceChar = sc.next().charAt(0);

		char stringArray[] = string.toCharArray();
		
		for (int i = 0; i < stringArray.length; i++) {
		    
		    if(stringArray[i] == character){
                stringArray[i] = replaceChar;
            }
		}

        System.out.println("The string with replaced character: i");
		System.out.println(stringArray);
	}
}
