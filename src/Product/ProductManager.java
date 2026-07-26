package Product;
import java.util.Scanner;
import BST.*;

import java.io.*;
import java.util.HashSet;

public class ProductManager {
    static File file = new File("products.txt");
    static HashSet<Integer> productIds = new HashSet<>();



    Scanner sc = new Scanner(System.in);
    Tree tree = new Tree();

    public ProductManager(){
        productRead();

    }


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

        boolean isIdUsed = productIds.contains(productId);

        while(isIdUsed){
            System.out.println("This Id is used already!");
            System.out.println("1.Re Enter the Id");
            System.out.println("2.Exit");
            
            int i = sc.nextInt();
            if(i==1){
                System.out.println("Enter the Id:");
                productId = sc.nextInt();

                isIdUsed = productIds.contains(productId);

            }
            else{
                return;
            }
            
        }

        Product product = new Product(productId,name,sellingPrice,costPrice,quantity,reorderLevel);

        try(FileWriter writer = new FileWriter("products.txt",true)){
            writer.write(product.toString());
            writer.write(System.lineSeparator());
            productIds.add(product.getId());


        }
        catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();

        }
        //Node node = new Node(productId,product);
        // Node node = new Node(product.productID,produtct) product.productID is error why?
        
        tree.insert(productId,product);


        




    }
    public static  void productRead(){
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Product product = new Product(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]),Double.parseDouble(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]));
                productIds.add(product.getId());
            }


        }
        catch(FileNotFoundException e){
            try{
                if(file.createNewFile()){
                    System.out.println("File is crreated:"+file.getName());
                }
            }
            catch(IOException n){
                System.out.println("Error:");
                n.printStackTrace();
            }

        }



    }
    
}
