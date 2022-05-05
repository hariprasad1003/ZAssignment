/*

Write a program to print the Fibonacci series. 

Input: 7
Output: 1, 1, 2, 3, 5, 8, 13

*/

import java.util.Scanner;

public class fibonacciSeries{
    public static void printFibonacciSeries(int input){
        int numberOne = 1, numberTwo = 1, result;
        System.out.println("The Fibonacci series: ");
        System.out.println(numberOne);
        System.out.println(numberTwo);

        for(int i = 2; i < input; i++){
            result = numberOne + numberTwo;
            System.out.println(result);
            numberOne = numberTwo;
            numberTwo = result;
        }

    }
    public static void main(String[] args){

        int input;
        System.out.println("Enter the position till the Fibonacci series to be printed: ");
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        printFibonacciSeries(input);
    }
}