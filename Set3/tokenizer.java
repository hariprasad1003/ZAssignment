/*

Write a program to tokenize a string with a delimiter.

*/
import java.util.StringTokenizer;  

public class tokenizer{  
    public static void main(String args[]){  
        StringTokenizer tokenizer = new StringTokenizer("Tokenize a string with a delimiter"," ");  
        System.out.println("Tokenized string: ");  
        while (tokenizer.hasMoreTokens()) {  
            System.out.println(tokenizer.nextToken());  
        }  
    }  
}  