package FileHandaling;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import Customer.*;




public class CustomerFile {
    File file = new File("Customer.txt");
   
    public  void reader(){
        
        
        
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Customer customer = new Customer(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4]);
                CustomerManager.customerTable.insert(customer.getId(),customer);


            }

        }
        catch(FileNotFoundException e){
            try{
                if(file.createNewFile()){
                    System.out.println("File is created;"+file.getName());
            
                }
            }
            catch(IOException n){
                System.out.println("Error");
                n.printStackTrace();
            }
            
        }
    }
    public void write(Customer customer){
        
        try(FileWriter writer = new FileWriter("Customer.txt",true)){
            writer.write(customer.toString());
            writer.write(System.lineSeparator());

        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public void updateFile(Customer deleteCustomer){
        File temfile = new File("Temperary.txt");
        try(
            Scanner reader = new Scanner(file);
            FileWriter writer = new FileWriter("Temperary.txt",true)

        ){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Customer customer = new Customer(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4]);
                if(customer.getId()==deleteCustomer.getId()){
                    continue;
                }
              
                writer.write(customer.toString());
                writer.write(System.lineSeparator());


            }
            

        }
        catch(IOException e){
            System.out.print("Error");
            e.printStackTrace();
            return;
        }
        file.delete();
        temfile.renameTo(file);

    }
    
}
