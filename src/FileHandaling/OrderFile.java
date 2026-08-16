package FileHandaling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Customer.Customer;
import Order.*;

import Item.*;
import Product.*;
import java.time.*;




public class OrderFile {
     File file = new File("Order.txt");
   
    public  void reader(){
        
        
        
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                String[] itemArray = data[4].split("\\|");
                
                Order order = new Order();
                for(int i=0;i<itemArray.length;i++){
                    String[] itemData = itemArray[i].split(":");
                    Product product = new Product(Integer.parseInt(itemData[2]),itemData[3],Double.parseDouble(itemData[4]),Double.parseDouble(itemData[5]));
                    Item item = new Item(product,Double.parseDouble(itemData[1]));
                    item.setId(Integer.parseInt(itemData[0]));
                    order.addItemToList(item);
                }
                order.setId(Integer.parseInt(data[0]));
                order.setTime(LocalTime.parse(data[1]));
                order.setDate(LocalDate.parse(data[2]));
                order.setStatus(data[3]);
                OrderManager.lastOrderNumber = order.getId();
                

                OrderManager.queue.insert(order);
                OrderManager.orderSet.add(order.getId());



               

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
    public void write(Order order){
        
        try(FileWriter writer = new FileWriter("Order.txt",true)){
            writer.write(order.toString());
            writer.write(System.lineSeparator());

        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public void updateCancel(Order cancelOrder){
        File temfile = new File("Temperary.txt");
        try(
            Scanner reader = new Scanner(file);
            FileWriter writer = new FileWriter("Temperary.txt",true)

        ){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                String[] itemArray = data[4].split("\\|");
                
                Order order = new Order();
                for(int i=0;i<itemArray.length;i++){
                    String[] itemData = itemArray[i].split(":");
                    Product product = new Product(Integer.parseInt(itemData[2]),itemData[3],Double.parseDouble(itemData[4]),Double.parseDouble(itemData[5]));
                    Item item = new Item(product,Double.parseDouble(itemData[1]));
                    item.setId(Integer.parseInt(itemData[0]));
                    order.addItemToList(item);
                }
                order.setId(Integer.parseInt(data[0]));
                order.setTime(LocalTime.parse(data[1]));
                order.setDate(LocalDate.parse(data[2]));
                order.setStatus(data[3]);
                //OrderManager.lastOrderNumber = order.getId()
                if(order.getId()==cancelOrder.getId()){
                    order.setStatus();
                }
              
                writer.write(order.toString());
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
     public void updateDelete(Order deleteOrder){
        File temfile = new File("Temperary.txt");
        try(
            Scanner reader = new Scanner(file);
            FileWriter writer = new FileWriter("Temperary.txt",true)

        ){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                String[] itemArray = data[4].split("\\|");
                
                Order order = new Order();
                for(int i=0;i<itemArray.length;i++){
                    String[] itemData = itemArray[i].split(":");
                    Product product = new Product(Integer.parseInt(itemData[2]),itemData[3],Double.parseDouble(itemData[4]),Double.parseDouble(itemData[5]));
                    Item item = new Item(product,Double.parseDouble(itemData[1]));
                    item.setId(Integer.parseInt(itemData[0]));
                    order.addItemToList(item);
                }
                order.setId(Integer.parseInt(data[0]));
                order.setTime(LocalTime.parse(data[1]));
                order.setDate(LocalDate.parse(data[2]));
                order.setStatus(data[3]);
                //OrderManager.lastOrderNumber = order.getId()
                if(order.getId()==deleteOrder.getId()){
                    continue;
                }
              
                writer.write(order.toString());
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
