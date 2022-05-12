/*

Difference between HashMap and HashTable

HashMap allows one or more null values, whereas HashTable doesn't null values

*/

import java.util.*;  

public class hashMap{  
    public static void main(String args[]){  

        HashMap<Integer,String> map=new HashMap<Integer,String>();
        map.put(1, "Hari");
        map.put(2, "Prasad");    
        map.put(3, "Gokul");   
        map.put(4, "Krishnan"); 
        map.put(5, "Raghul Ravi");
        map.put(2, "Ahamed"); 

        System.out.println("Names in Hashmap: ");  
        for(Map.Entry m : map.entrySet()){    
            System.out.println(m.getKey() + " " + m.getValue());    
        }  
        System.out.println("\n");

        map.putIfAbsent(6, "Rohith");

        System.out.println("Names in Hashmap After Updation: ");  
        for(Map.Entry m : map.entrySet()){    
            System.out.println(m.getKey() + " " + m.getValue());    
        }  
        System.out.println("\n");

        map.remove(6);
        System.out.println("Names in Hashmap After Deletion: ");  
        for(Map.Entry m : map.entrySet()){    
            System.out.println(m.getKey() + " " + m.getValue());    
        }
        System.out.println("\n");

        map.put(6, "Vishnu");
        map.replace(6, "Praveen");
        map.put(7, null);
        System.out.println("Names in Hashmap After Replacing the Values: ");  
        for(Map.Entry m : map.entrySet()){    
            System.out.println(m.getKey() + " " + m.getValue());    
        }
    }  
}  