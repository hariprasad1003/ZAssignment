import java.io.FileReader;
import java.io.IOException;

public class reader{
    public static void main(String[] args) throws IOException{
        FileReader reader = new FileReader("file.txt");
        int data;
        while((data = reader.read()) != -1){
            char character = (char) data;
            System.out.print(character);
        }
        System.out.print('\n');
    }
}