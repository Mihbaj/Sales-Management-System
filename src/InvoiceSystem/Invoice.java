package InvoiceSystem;
import java.time.LocalTime;
import java.time.LocalDate;
import Item.*;
import java.util.ArrayList;

public class Invoice{
    private String invoiceId;
    private LocalTime time = LocalTime.now();
    private LocalDate date= LocalDate.now();
    private ArrayList<Item> itemList = new ArrayList<>();
    private double totalAmount=0;
    private String paymentMethod;
    private String paymentStatus;

    public void addItemToList(Item item){
        itemList.add(item);
    }
    public LocalDate getDate(){
        return date;
    }
    public void setId(String id){ 
        invoiceId = id;
    }
    public void setTotalAmount(double price){
        totalAmount+= price;

    }
    public double getTotalAmount(){
        return totalAmount;
    }
    public void setMethod(String method){
        paymentMethod = method;
    }
    public void setStatus(String status){
        paymentStatus = status;

    }
    public ArrayList<Item> getList(){
        return itemList;
    }
    public void display(){
        System.out.println("----------------------------");
        System.out.println("-------------SAMA Store------------------");
        System.out.println("Invoice Id:"+invoiceId);
        System.out.println("Date:"+date);
        System.out.println("Time:"+time);
        
        
        for(int i=0;i<itemList.size();i++){
            Item item = itemList.get(i);
            item.displayItem();
        }
        System.out.println("Totol Amound:"+totalAmount);
        

    }
  




    


}