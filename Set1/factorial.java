/*

Write a program to Factorial of n numbers.

Input: 7
Output: 1, 2, 6, 24, 120, 720, 5040

*/

import java.util.Scanner;

public class factorial{

    public static int getFactorial(int number){

        int result = 1;

        while(number != 0){
            result *= number;
            number -= 1;
        }

        return result;

    }

    public static void main(String[] args){
        int n, result;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the N number: ");
        n = sc.nextInt();

        System.out.print("Factorial of " + n + " as follows: ");

        for(int i = 1; i <= n; i++){
            result = getFactorial(i);
            System.out.print(result + ",");
        }

        System.out.print("\n");
        
    }
}