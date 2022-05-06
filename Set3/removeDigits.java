/*

Write a program to eliminate numeric values in a string.

*/

import java.util.Scanner;

class removeDigits {
	public static void main(String args[])
	{

		String string;
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Input String: ");
        string = sc.next();
		char stringArray[] = string.toCharArray();
		String result = "";

		for (int i = 0; i < stringArray.length; i++) {
		    
		    int character = (int) stringArray[i];

			if (!(character >= 48 && character <= 57)) {
				result = result + stringArray[i];
			}
		}

		System.out.println(result);
	}
}
