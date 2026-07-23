package Product;
import java.util.Scanner;
import BST.*;

public class ProductManager {

    Scanner sc = new Scanner(System.in);
    Tree tree = new Tree();

    public void addProduct(){
        System.out.println("Please Enter the following Date");
        System.out.println("------------------------------------------");

        System.out.println("productId: ");
        int productId = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Selling Prince: ");
        double sellingPrice = sc.nextDouble();
        System.out.println("Cost Price: ");
        double costPrice = sc.nextDouble();
        System.out.println("Quantity: ");
        int quantity = sc.nextInt();
        System.out.println("Reorder Level: ");
        int reorderLevel = sc.nextInt();

        Product product = new Product(productId,name,sellingPrice,costPrice,quantity,reorderLevel);
        //Node node = new Node(productId,product);
        // Node node = new Node(product.productID,produtct) product.productID is error why?
        
        tree.insert(productId,product);


        




    }
    
}
