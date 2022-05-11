/*

Write a java program to print the system properties using the System class.

*/

import java.util.Properties;
 
public class systemProperties{
    public static void main(String[] args) {
        System.out.println("System Properties: ");
        System.out.println(System.getProperties());
    }
}