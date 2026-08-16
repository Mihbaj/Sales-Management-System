package Item;
import Product.*;
import java.util.Scanner;

public class ItemManager {
    

    Scanner scanner = new Scanner(System.in);
    ProductManager manager = new ProductManager();

    public Item createItem(){
       
        System.out.println("Ender the Product ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean checkIsAvailable = manager.searchProduct( id);
        while(!checkIsAvailable){
            System.out.println("This product is not founded!");
            System.out.println("Do you Want to Re enter product id(yes/no)");
            String ans = scanner.nextLine();

            if(ans.equalsIgnoreCase("yes")){
                System.out.println("Re enter the product id:");
                id = scanner.nextInt();
                checkIsAvailable = manager.searchProduct(id);
                
                

            }
            else{
                return null;
            }

        }
        Product product = manager.getProduct(id);
        System.out.println("Enter the quantity:");
        double quantity = scanner.nextDouble();

        Item item = new Item(product,quantity);
        return item;

    }
    
}
