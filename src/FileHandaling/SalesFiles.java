package FileHandaling;
import  Sales.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import Item.*;
import java.time.LocalDate;




public class SalesFiles{
    public  void reader(){
        
        File file = new File("Sales.txt");
        
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                String itemString = data[4];
                String[] itemsArray =itemString.split("\\|");
                ArrayList<SaleItem> itemList = new ArrayList<>();
                for(int i=0;i<itemsArray.length;i++){
                    String[] itemData = itemsArray[i].split(":");
                    
                    SaleItem item = new SaleItem(itemData[1],Double.parseDouble(itemData[2]),Double.parseDouble(itemData[3]));
                    item.setId(Integer.parseInt(itemData[0]));
                    itemList.add(item);

                }
                
                Sales sale = new Sales(data[0],data[1],data[2],LocalDate.parse(data[3]),itemList);
                SalesManager.tree.insert(sale.getTreeId(),sale);


             
             
        
                


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

    public void write(Sales sale){
        
        try(FileWriter writer = new FileWriter("Sales.txt",true)){
            writer.write(sale.toString());
            writer.write(System.lineSeparator());

        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public void delete(){

    }

}