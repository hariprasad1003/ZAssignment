import java.io.FileWriter;
import java.io.IOException;

public class writer{
    public static void main(String[] args) throws IOException{
        FileWriter writer = new FileWriter("file.txt");
        writer.write("Hello World");
        writer.close();
    }
}