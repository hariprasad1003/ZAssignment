/*

Explore and demonstrate packages with programs.

Packages are used to organize similar classes.

Packages can be categorized into two:

- Built-in Packages
- User defined Packages

Built-in Packages such as java.util, java.lang, java.io..

Follow the below commands to create a Java User Defined Packages

javac -d . packages.java 
javac -d . userDefinedPackages.java 
java pack1.packages
*/

// User Defined Package
package pack1;

import pack1.userDefinedPackages;

// Built-in Package
import java.util.Date;

class packages{
    public static void main(String[] args){

        Date date = new Date();
        System.out.println("Built-in Package");
        System.out.println(date.toString());

        userDefinedPackages userDefined = new userDefinedPackages();
        System.out.println(userDefined.returnMessage());
        
    }
}