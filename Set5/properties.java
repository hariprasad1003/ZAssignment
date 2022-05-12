import java.util.*;
import java.io.*;

public class properties{

    public static void createProperties() throws IOException{

        Properties prop = new Properties();
        prop.setProperty("name", "Hari Prasad");
        prop.setProperty("email", "hariprasad@gmail.com");

        FileWriter filewriter = new FileWriter("info.properties");
  
        prop.store(filewriter, "Info Properties File");
    }

    public static void readProperties() throws IOException{
        
        FileReader filereader = new FileReader("info.properties");

        Properties prop = new Properties();
  
        prop.load(filereader);
  
        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("email"));
    }

    public static void readSystemProperties(){

        Properties props = System.getProperties();
        props.list(System.out);
    }


    public static void main(String[] args) throws IOException{
        createProperties();
        readProperties();
        readSystemProperties();
    }
}