package InvoiceSystem;
import java.time.LocalTime;
import java.time.LocalDate;
import Item.*;
import java.util.ArrayList;
public class Invoice{
    private String invoiceId;
    private LocalTime time;
    private LocalDate date;
    private ArrayList<Item> itemList = new ArrayList<>();
    private double totalAmount=0;
    private String paymentMethod;
    private String paymentStatus;

    public void addItemToList(Item item){
        itemList.add(item);
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




    


}