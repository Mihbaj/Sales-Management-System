package Order;
import java.util.LinkedList;
import java.time.LocalTime;
import java.time.LocalDate;
import Item.*;


public class Order {
    private int orderId;
    private LocalTime time = LocalTime.now();
    private LocalDate date = LocalDate.now();   
    private LinkedList<Item> itemList = new LinkedList<>();
    private int totalOrder;
    private int balanceOrder;
    
    public Order(){
        orderId = totalOrder+1;
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
    public void displayOrder(){
        System.out.println("Order Id:"+orderId);
        System.out.println("Date:"+date+", Time:"+time);
        System.out.println("Order Items:");
        for(int i=0;i<itemList.size();i++){
            Item  item = itemList.get(i);
            item.displayItem();
            System.out.println("--------------------");

        }


    }

}
