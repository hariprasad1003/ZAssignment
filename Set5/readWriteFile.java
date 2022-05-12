import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class readWriteFile{
    public static void main(String[] args) throws IOException{

        String string = "Hello World";
 
        FileWriter filewriter = new FileWriter("file.txt");
 
        for (int i = 0; i < string.length(); i++)
            filewriter.write(string.charAt(i));
 
        filewriter.close();

        int character;
        FileReader filereader = null;
        try
        {
            filereader = new FileReader("file.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
 
        while ((character=filereader.read())!=-1)
            System.out.print((char)character);

        System.out.print("\n");
        filereader.close();

    }
}