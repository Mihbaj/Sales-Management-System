package InvoiceSystem;
import Item.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Scanner;
import Payment.*;
import java.util.ArrayList;
import Product.*;
import Sales.*;

public class InvoiceManager {
    Scanner scanner = new Scanner(System.in);
    ItemManager manager = new ItemManager();
    SalesManager saleManager = new SalesManager();




    public void createInvoice(){
        Invoice invoice = new Invoice();
        PaymentManager payment = new PaymentManager();

        boolean Boolean = true;
         int nItem=0;
         ArrayList<SaleItem> saleList = new ArrayList<>();
        while(Boolean){
            Item newItem = manager.createItem();
            
            if(newItem != null){
                
                newItem.setId(nItem);
                invoice.addItemToList(newItem);
                nItem++;
                
                SaleItem Saleitem = new SaleItem(newItem.getProductName(),newItem.getQuntity(),newItem.getPrice());
                saleList.add(Saleitem);
                System.out.println("Do you Want to add more Item(yes/no):");
                String ans = scanner.nextLine();
                while(ans.equalsIgnoreCase("yes")&& ans.equalsIgnoreCase("no")){
                    System.out.println("Enter only yes or no:");
                    ans=scanner.nextLine();
                }
                invoice.setTotalAmount(newItem.getPrice());
                if(ans.equalsIgnoreCase("no")){
                    Boolean = false;
                    nItem=0;
                    
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
        System.out.println("TotalAmount:"+invoice.getTotalAmount());
        System.out.println("Do you want to continue payment (or cencel invoice)(yes/no):");
        String an = scanner.nextLine();
        while(!an.equalsIgnoreCase("yes")&&!an.equalsIgnoreCase("no")){
            System.out.println("Enter only yes or no:");
            an=scanner.nextLine();
        }
        if(an.equalsIgnoreCase("yes")){

            Payment pay =payment.createPayment(invoice);
            invoice.setId(pay.getId());
            //ArrayList<Item> list = invoice.getList();
            
                //here we must update the quantiy
            System.out.println("Blance:"+pay.getBalance());
            invoice.setMethod(pay.getMethod());
            invoice.setStatus(pay.getStatus());
            saleManager.createSale(pay.getId(),pay.getMethod(),pay.getStatus(),invoice.getDate(),saleList);

            

        
            System.out.println("Do yo want to  print invoice(yes/no):");
            String pr=scanner.nextLine();
            while(!pr.equalsIgnoreCase("yes")&&!pr.equalsIgnoreCase("no")){
                System.out.println("Enter only yes or no:");
                pr=scanner.nextLine();
            }
            if(pr.equalsIgnoreCase("no")){
                return;

            }
            else{
                invoice.display();
                pay.displayPayment();
            }
            //for(int i =0;i<list.size();i++){    


            //}


        }

        
        

        


       
        // we did not created user we choose user her; i did not add the price here
        
        

        

    }
    
}
