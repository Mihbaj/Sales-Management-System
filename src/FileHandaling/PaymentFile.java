package FileHandaling;
import java.io.*;
import Payment.*;

import java.util.Scanner;

public class PaymentFile {

    public  void reader(){
        
        File file = new File("Payment.txt");
        
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Payment payment = new Payment(Double.parseDouble(data[1]),Double.parseDouble(data[2]),data[3],data[4]);
                payment.setId(data[0]);
                payment.setLastPayment(Integer.parseInt(data[5]));
                PaymentManager.paymentTable.insert(data[0],payment);
                PaymentManager.lastNumber= payment.getLastPaymentNumber();


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
    public void write(Payment payment){
        
        try(FileWriter writer = new FileWriter("Payment.txt",true)){
            writer.write(payment.toString());
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
