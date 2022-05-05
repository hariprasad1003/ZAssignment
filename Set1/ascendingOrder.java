/*

Write a program to sort (Ascending order) the given Array. 

Input: 8, 188, 2, 1, 55, 245
Ouput: 1, 2, 8, 55, 188, 245

*/


/*
public class ascendingOrder{
    public static void main(String[] args){
        // int array[] = {8, 188, 2, 1, 55, 245};

        int size = array.length;

        for(int i = 0; i < size; i++)
        {
            for(int j = i + 1; j < size; j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.print("The Sorted Array in Ascending Order: ");

        for(int i = 0; i < size; i++)
        {
            System.out.print(array[i] + ", ");
        }

        System.out.print("\n");
    }
}
*/

import java.util.Scanner;

public class ascendingOrder{
    public static void main(String[] args){
        String inputString;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Input: ");
        inputString = sc.next();

        int inputLength = inputString.length();

        char array[] = new char[inputLength];

        for(int i = 0; i < inputLength; i++){
            array[i] = inputString.charAt(i);
        }

        int size = array.length;

        for(int i = 0; i < size; i++)
        {
            for(int j = i + 1; j < size; j++){

                int element_one = (int) array[i];
                int element_two = (int) array[j];

                if(element_one > element_two){
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.print("The Sorted Array in Ascending Order: ");

        for(int i = 0; i < size; i++)
        {
            System.out.print(array[i] + ", ");
        }

        System.out.print("\n");
    }
}