package Employee;
import java.io.*;

public class File {
    private static final String fileName = "product.txt";
    
    
    public void fileWriter(){
        try(FileWriter writer = new FileWriter(fileName,true)){
            writer.write( Employee.toString());
            writer.write(System.lineSeparator());
        }
        catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();
        }
        

    }
    
}
