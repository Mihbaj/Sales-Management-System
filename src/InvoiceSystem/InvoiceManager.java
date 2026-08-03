package Invoice;
import Item.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Scanner;
import Payment.*;

public class InvoiceManager {
    Scanner scanner = new Scanner(System.in);
    ItemManager manager = new ItemManager();


    public void createIvoice(){
        Invoice invoice = new Invoice();
        Payment payment = new Payment();

        boolean Boolean = true;
        while(Boolean){
            Item newItem = manager.createItem();
            if(newItem != null){
                
                invoice.addItemToLinkedList(newItem);
                System.out.println("Do you Want to add more Item(yes/no):");
                String ans = scanner.nextLine();
                invoice.setTotalAmount(newItem.getPrice());
                if(ans.equalsIgnoreCase("no")){
                    Boolean = false;
                    
                }
                

            }
            else{
                System.out.println("This product is not founded!");
                System.out.println("Do you want to add Item(yes/no):");
                String ans = scanner.nextLine();
                if(ans.equalsIgnoreCase("no")){
                     Boolean = false;
                }


            }
        }

        payment.createPayment(invoice);

       
        // we did not created user we choose user her; i did not add the price here
        
        

        

    }
    
}
