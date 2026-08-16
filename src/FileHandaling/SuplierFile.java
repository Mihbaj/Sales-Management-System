package FileHandaling;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

import Supplier.*;


public class SuplierFile {
        File file = new File("Supplier.txt");
   
    public  void reader(){
        
        
        
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Supplier supplier = new Supplier(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4],data[5]);
                SupplierManager.graph.addVertex(supplier.getId()+supplier.getName());
                String[] names = data[6].split(":");
                for(int i=0;i<names.length;i++){
                    supplier.addProductName(names[i]);
                    SupplierManager.graph.addEdge((supplier.getId()+supplier.getName()),names[i]);
                }
                SupplierManager.supplierTable.insert(supplier.getId(),supplier);


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
    public void write(Supplier supplier){
        
        try(FileWriter writer = new FileWriter("Supplier.txt",true)){
            writer.write(supplier.toString());
            writer.write(System.lineSeparator());

        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public void updateFile(Supplier deleteSupplier){
        File temfile = new File("Temperary.txt");
        try(
            Scanner reader = new Scanner(file);
            FileWriter writer = new FileWriter("Temperary.txt",true)

        ){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Supplier supplier = new Supplier(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4],data[5]);
                String[] names = data[6].split(":");
                for(int i=0;i<names.length;i++){
                    supplier.addProductName(names[i]);
                    //SupplierManager.graph.addEdge((supplier.getId()+supplier.getName()),names[i]);
                }
                if(supplier.getId()==deleteSupplier.getId()){
                    continue;
                }
              
                writer.write(supplier.toString());
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
