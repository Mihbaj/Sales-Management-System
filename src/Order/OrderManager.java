package Order;
import Item.*;
import StackAndQueue.*;
import java.util.Scanner;
import HashTable.SetADT;
import FileHandaling.OrderFile;
import SortingAlgorithams.*;

public class OrderManager {
    
    ItemManager manager = new ItemManager();
    public static Queue<Order> queue = new Queue<>();
    public static SetADT<Integer> orderSet = new SetADT<>();
    OrderFile filemanager = new OrderFile();

    public static int lastOrderNumber;

    boolean fileload = true;
    public OrderManager(){
        if(fileload){
            filemanager.reader();

        }
    }
   

    public void createOrder(){
        int totalitem =1;
        Order order = new Order();
        

        boolean choice = true;

        while(choice){
            Scanner scanner = new Scanner(System.in);
            Item newItem = manager.createItem();
            newItem.setId(totalitem);
            totalitem++;
            order.addItemToList(newItem);
            System.out.println("Do you want to add more item(yes/no):");
            String ans = scanner.nextLine();
            if(ans.equalsIgnoreCase("no")){
                choice = false;
                System.out.println("Do you Conform this Order(yes/no):");
                String conform = scanner.nextLine();
                if(conform.equalsIgnoreCase("yes")){
                    order.setId(lastOrderNumber+1);
                    lastOrderNumber=order.getId();
                    filemanager.write(order);

                    queue.insert(order);
                    orderSet.add(order.getId());
                    System.out.println("Order is added succesfully");

                }
                else{
                    System.out.println("This order is canceled");
                    return;
                }
                
            }
            
        }      

    }
    
    public void cancelOrder(){
        Scanner scanner = new Scanner(System.in);
        int cancelId;
        while(true){
            System.out.println("Enter the Order Id:");
            cancelId = scanner.nextInt();
            scanner.nextLine();
            if(orderSet.contains(cancelId)){
                System.out.println("Do you want cancel the Order(yes/no):");
                String ans = scanner.nextLine();
                if(ans.equalsIgnoreCase("no")){
                    return;
                }
                else if(ans.equalsIgnoreCase("yes")){
                    Node<Order> current = queue.getFront();
                    while(current!=null){
                        if(current.data.getId()==cancelId){
                            current.data.setStatus();
                            filemanager.updateCancel(current.data);
                            System.out.println("Order is canceled succesfully");
                            break;

                        }
                        current = current.next;
                    }
                    break;

                   
                    
               

                }
                else{
                    System.out.println("Invalid Input");
                    return;
                }
            }
            else{
                System.out.println("This id is not exit");
            }


        }
    }/* 
    public void deleteOrder(){
        Scanner scanner = new Scanner(System.in);
        int deleteId;
        while(true){
            System.out.println("Enter the Order Id:");
            deleteId = scanner.nextInt();
            scanner.nextLine();
            if(orderSet.contains(deleteId)){
                System.out.println("Do you want delete the Order(yes/no):");
                String ans = scanner.nextLine();
                if(ans.equalsIgnoreCase("no")){
                    return;
                }
                else if(ans.equalsIgnoreCase("yes")){
                    Order order = queue.remove();
                    orderSet.remove(order.getId());
                    filemanager.updateDelete(order);
                    lastOrderNumber--;
                    System.out.println("Order id deleted succesfully");
                    break;

                }
                else{
                    System.out.println("Invalid Input");
                    return;
                }
            }
            else{
                System.out.println("This Id is not Exit");
            }


        
            
        }
    }
        
        /* 
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
        }*/
        
        

     
    public void getNextOrder(){
        Order nextOrder = queue.peek();
        nextOrder.displayOrder();
        
        
    
    }
    public void removeOrder(){
        Order order = queue.remove();
        orderSet.remove(order.getId());
        filemanager.updateDelete(order);
        System.out.println("Order id deleted succesfully");
    }
    public void displayAll(){
        Sorting<Integer> sorting = new Sorting<>();
        Integer[] array = new Integer[orderSet.size()];
        int index=0;
        Node<Order> current = queue.getFront();
        if(current==null){
            System.out.println("There are no Orders");
            return;
        }
        while(current!=null){
            Order order = current.data;
            if(order!=null){
                array[index]=order.getId();
                index++;
                current = current.next;
            }
        }
        sorting.mergeSort(array,0,array.length-1);
        for(int i =0;i<array.length;i++){
            Node<Order> cr = queue.getFront();
            while(cr!=null){
                if(cr.data.getId()==array[i]){
                    cr.data.displayOrder();
                    break;
                }
                cr = cr.next;
            }
        }




    }
    
}
