package Order;
import java.util.LinkedList;
import java.time.LocalTime;
import java.time.LocalDate;
import Item.*;
import LinkList.*;


public class Order {
    private int orderId;
    private LocalTime time = LocalTime.now();
    private LocalDate date = LocalDate.now();   
    private LinkedList<Item> itemList = new LinkedList<>();
    //private int totalOrder;
    //private int balanceOrder;
    private String status = "Active";
    
    public Order(){
        
    }
    public void setId(int id){
        orderId = id;
    }
    public void setTime(LocalTime time){
        this.time = time;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }

    
    public void addItemToList(Item item){
        if(item!=null){
            itemList.add(item);
        }
        else{
            System.out.println("Item can be null");
        }
    }
    public int getId(){
        return orderId;
    }
    public void setStatus(){
        status ="De Active";
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void displayOrder(){
        System.out.println("Order Id:"+orderId);
        System.out.println("Date:"+date+", Time:"+time);
        System.out.println("Status:"+status);
        System.out.println("Order Items:");
        for(int i=0;i<itemList.size();i++){
            Item  item = itemList.get(i);
            item.displayItem();
            System.out.println("--------------------");

        }


    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<itemList.size();i++){
            builder.append(itemList.get(i).toString());
            if(i!=(itemList.size()-1)){
                builder.append("|");
            }
        }
        String items = builder.toString();
        return orderId+","+time+","+date+","+status+","+items;
    }

}
