import java.util.*;  

public class hashTable{  
    public static void main(String args[]){  
        Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>();
        hashTable.put(1, "Rose");
        hashTable.put(2, "Jasmine");
        hashTable.put(3, "Lavender");

        System.out.println(hashTable);
        
        hashTable.remove(3);

        System.out.println(hashTable);
        
        hashTable.replace(2, "Lily");
        
        System.out.println(hashTable);

        // Unlike Hashmap, Hashtable doesn't allow null values

        hashTable.put(3, null);
        System.out.println(hashTable);
    }  
}  