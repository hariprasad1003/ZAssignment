/*

Write a program to split a string into two/more with a delimiter.

*/

import java.util.Scanner;  

public class delimiter  
{  
    public static void main(String[] args)   
    {  
        String string="split a string into two or more with a delimiter";  
        Scanner sc = new Scanner(string);  
        while(sc.hasNext())   
        {  
            String tokens=sc.next();  
            System.out.println(tokens);  
            
        }  
        sc.close(); 
    }  
}  
