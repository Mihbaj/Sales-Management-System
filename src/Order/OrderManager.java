package Order;
import Item.*;
import StackAndQueue.*;
import java.util.Scanner;

public class OrderManager {
    ItemManager manager = new ItemManager();
    OrderQueue queue = new OrderQueue();
    Scanner scanner = new Scanner(System.in);

    public void createOrder(){
        Order order = new Order();

        boolean choice = true;

        while(choice){
            Item newItem = manager.createItem();
            order.addItemToOrder(newItem);
            System.out.println("Do you want to add more item(yes/no):");
            String ans = scanner.nextLine();
            if(ans.equalsIgnoreCase("no")){
                choice = false;
                queue.add(order);


            }
            
        }
        
        
        
       

    }
    
}
