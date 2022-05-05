/*

Write a program to find the biggest number in a given array. 

Input: 8, 188, 2, 1, 55, 245
Ouput: 245

*/

public class biggestNumberArray{
    public static void main(String[] args){
        // int array[] = new int[5];
        int array[] = {8, 188, 2, 1, 55, 245};
        int biggestNumber = 0;
        int size = array.length;
        for(int i = 0; i < size; i++)
        {
            if(array[i] > biggestNumber){
                biggestNumber = array[i];
            }

        }
        System.out.println("Biggest number in a given array is " + biggestNumber);
    }
}