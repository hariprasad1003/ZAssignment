/*

Write a program to split a string into two/more with a delimiter.

*/

import java.util.Scanner;  

// public class delimiter  
// {  
//     public static void main(String[] args)   
//     {  
//         String string="split a string into two or more with a delimiter";  
//         Scanner sc = new Scanner(string);  
//         while(sc.hasNext())   
//         {  
//             String tokens=sc.next();  
//             System.out.println(tokens);  
            
//         }  
//         sc.close(); 
//     }  
// }  

public class delimiter  
{  
    public static void main(String[] args)   
    {  
        String string, delimiter;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        string = sc.next();
        System.out.println("Enter the delimiter: ");
        delimiter = sc.next();

        String[] tokens=string.split(delimiter);
        for(int i = 0; i < tokens.length; i++){
            System.out.println(tokens[i]);
        }  
    }  
}  