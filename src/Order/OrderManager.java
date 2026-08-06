package Order;
import Item.*;
import StackAndQueue.*;
import java.util.Scanner;
import java.util.HashSet;

public class OrderManager {
    ItemManager manager = new ItemManager();
    Queue<Order> queue = new Queue<>();
    HashSet<Integer> userSet = new HashSet<>();
    Scanner scanner = new Scanner(System.in);

    public void createOrder(){
        Order order = new Order();

        boolean choice = true;

        while(choice){
            Item newItem = manager.createItem();
            order.addItemToList(newItem);
            System.out.println("Do you want to add more item(yes/no):");
            String ans = scanner.nextLine();
            if(ans.equalsIgnoreCase("no")){
                choice = false;
                System.out.println("Do you Conform this Order(yes/no):");
                String conform = scanner.nextLine();
                if(conform.equalsIgnoreCase("yes")){
                queue.insert(order);
                userSet.add(order.getId());

                }
                else{
                    System.out.println("This order is canceled");
                    return;
                }
                
            }
            
        }      

    }
    /* 
    public void deleteOrder(){
        System.out.println("Enter the Order Id:");
        int deleteId = scanner.nextInt();
        scanner.nextLine();
        
        while(!userSet.contains(deleteId)){
            System.out.println("Thsi id is not found");
            System.out.println("Do you want to continue(yes/no)");
            String ans = scanner.nextLine();
            if(ans.equalsIgnoreCase("no")){
                return;
            }
            else{
                System.out.println("Enter the Order Id:");
                deleteId= scanner.nextInt();
                scanner.nextLine();
                
            }
        }
        
        

    } */
    public void getNextOrder(){
        Order nextOrder = queue.peek();
        nextOrder.displayOrder();
        
        
    
    }
    public void removeOrder(){
        queue.remove();
        System.out.println("Order is removed successfully");
    }
    
}
