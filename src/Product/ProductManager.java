package Product;
import java.util.Scanner;
import BST.*;
import Employee.Employee;
import java.io.*;
import HashTable.*;
import LinkList.*;
import SortingAlgorithams.*;

public class ProductManager {
    static File file = new File("products.txt");
    static File  tem = new File("Temparary.txt");
    static SetADT<Integer> productIds = new SetADT<>();
    static HashTable<Integer,Product> productTable = new HashTable<>();
   


    Categories categorie = new Categories();
    Scanner sc = new Scanner(System.in);
    static Tree tree = new Tree();
   
    static private boolean fileload = true;

    public ProductManager(){
        if(fileload){
            productRead();
            fileload = false;


        }
        
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
        sc.nextLine();
        System.out.println("Categorie:");
        categorie.displayCategories();
        System.out.println("Entet the categorie number:");
        int num =sc.nextInt();

        
       

        boolean isIdUsed = productIds.contains(productId);

        while(isIdUsed){
            System.out.println("This Id is used already!");
            System.out.println("1.Re Enter the Id");
            System.out.println("2.Exit");
            System.out.println("Enter your choice:");
            int i = sc.nextInt();
            
            
            if(i==1){
                System.out.println("Enter the Id:");
                productId = sc.nextInt();

                isIdUsed = productIds.contains(productId);

            }
            else{
                return;
            }
            sc.nextLine();
            
        }

        Product product = new Product(productId,name,sellingPrice,costPrice);
        product.setCategorie(categorie.getCategorie(num));

        try(FileWriter writer = new FileWriter("products.txt",true)){
            writer.write(product.toString());
            writer.write(System.lineSeparator());
            tree.insert(product.getId(),product);
            productTable.insert(productId,product);
            productIds.add(product.getId());


        }
        catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();

        }

        
        //Node node = new Node(productId,product);
        // Node node = new Node(product.productID,produtct) product.productID is error why?
        
       


        




    }
    public void updateProduct(){
        int updateId;
        while(true){
            System.out.println("Enter the Product Id(that you want to update):");
            updateId = sc.nextInt();
            sc.nextLine();
            if(!productIds.contains(updateId)){
                System.out.println("This id is not exit");
                System.out.println("1. Re enter Id");
                System.out.println("2.Exit");
                System.out.println("Enter you choice:");
                int ans = sc.nextInt();
                if(ans==2){
                    return;
                }
                

            }
            else{
                break;
            }

        }
        Product updateProduct = getProduct(updateId);
        updateProduct.display();
        boolean run = true;
        while(run){
            System.out.println("1.Product Id");
            System.out.println("2.Name");
            System.out.println("3.Cost Price");
            System.out.println("4.Selling Price");
            System.out.println("5.Categorie");
            System.out.println("Enter your choice:");

            int ans = sc.nextInt();
            sc.nextLine();
            if(ans<1 || ans>6){
                System.out.println("Invalid Input");
                return;

            }
            if(ans ==1){
            int newId;
            while(true){
                System.out.println("Enter the Product Id(that you want to update):");
                newId = sc.nextInt();
                if(productIds.contains(newId)){
                    System.out.println("This id is used already");

                }
                else{
                    break;
                }
    
            }
            productIds.remove(updateId);
            productIds.add(newId);
            updateProduct.setId(newId);
            sc.nextLine();
            run = chooseReRun();

            
            }
            else if(ans ==2){
                System.out.println("Enter the new Name:");
                String newName = sc.nextLine();

                updateProduct.setName(newName);
                run = chooseReRun();

            }
            else if(ans== 4){
                System.out.println("Enter the new Sellling price:");
                double newSellingPrice = sc.nextDouble();
                updateProduct.setSellingPrice(newSellingPrice);
                run = chooseReRun();

            }
            else if (ans ==3){
                System.out.println("Enter the new Cost Price:");
                double newCostPrice = sc.nextDouble();
                updateProduct.setCostPrice(newCostPrice);
                run = chooseReRun();


            }
            else if(ans==5){
                categorie.displayCategories();
                System.out.println("Enter the new Categorie Number :");
                int newCategorie = sc.nextInt();
                updateProduct.setCategorie(categorie.getCategorie(newCategorie));
                run = chooseReRun();

            }
            else{
                System.out.println("Invalid Input");
                return;
            }


        }
        productTable.delete(updateId);
        productTable.insert(updateProduct.getId(),updateProduct);
        rewriteFile(updateId);
        fileWrite(updateProduct);
       

        
       
        

    }
    public void deleteProduct(){
        Scanner sc = new Scanner(System.in);
        int deleteId;
        while(true){
            System.out.println("Enter the product id(that you want to delete):");
            deleteId = sc.nextInt();
            sc.nextLine();
            if(!productIds.contains(deleteId)){
                System.out.println("Thsi id is not exit");
                System.out.println("Do you want to continue(yes/no):");
                String ans = sc.nextLine();
                if(ans.equalsIgnoreCase("no")){
                    return;
                }
                else if(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")){
                    System.out.println("Invalid Input");
                    return;
                }
            }
            else{
                break;
            }
           


        }
        tree.delete(deleteId);
        productIds.remove(deleteId);
        productTable.delete(deleteId);
        rewriteFile(deleteId);
        System.out.println("Product is deleted succesfully");
    }
    public static  void productRead(){
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Product product = new Product(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]),Double.parseDouble(data[3]));
                product.setCategorie(data[4]);
                productIds.add(product.getId());
                tree.insert(product.getId(),product);
                productTable.insert(product.getId(),product);

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
    
    public boolean searchProduct(int id){
        ProductNode node = tree.find(id);
        if(node==null){
            return false;
        }
        else{
            return true;
        }

    }
   
    public Product getProduct(int id){
        return productTable.search(id);
        // Note this one because i did not use if else 
    }
    public static void rewriteFile(int id){
        try{
            Scanner reader = new Scanner(file);
            FileWriter writer = new FileWriter(tem);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Product product = new Product(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]),Double.parseDouble(data[3]));
                product.setCategorie(data[4]);

                if(product.getId()!=id){
                    writer.write(line);
                    writer.write(System.lineSeparator());
                }
            }
            reader.close();
            writer.close();
            file.delete();
            tem.renameTo(file);
        }
        catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();
        }



    }
    public static boolean chooseReRun(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Do you want to continue update(yes/no):");
        
        String continueAnswer = scanner.nextLine();
        if(continueAnswer.equalsIgnoreCase("no")){
            return false;
        }
        else{
            
            return true;
        }
        
        


    }
    public void fileWrite(Product product){
        try(FileWriter writer = new FileWriter(file,true)){
            writer.write(product.toString());
            writer.write(System.lineSeparator());
        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public void displayAll(){
        Sorting<Integer> sorting = new Sorting<>();

        Object[] elements = productIds.returnElement();
        Integer[] array = new Integer[productIds.size()];
        for(int i =0;i<array.length;i++){
            array[i] = (Integer)elements[i];
        }
        sorting.bubbleSort(array);
        for(int i =0;i<array.length;i++){
            Product product = productTable.search(array[i]);
            product.display();
        }
        

    }
    public void search(){
        Scanner scanner = new Scanner(System.in);
        int searchId;
        while(true){
            System.out.println("Enter the Product Id:");
            searchId = scanner.nextInt();
            scanner.nextLine();

            if(!productIds.contains(searchId)){
                System.out.println("This id is not exit");
                System.out.println("Do you want to continue(yes/no):");
                String ans = scanner.nextLine();
                if(ans.equalsIgnoreCase("no")){
                    return;
                }
                else if(!ans.equalsIgnoreCase("no") && !ans.equalsIgnoreCase("yes")){
                    System.out.println("Invalid Input");
                    return;
                }
                

            }
            Product product = productTable.search(searchId);
            if(product!=null){
                product.display();
                break;


            }
            

        }
        

    }
    
    public void rangeSearch(ProductNode node, int min, int max) {

        if (node == null) {
            return;
        }

        int id = node.getProduct().getId();

        if (id > min) {
            rangeSearch(node.getLeft(), min, max);
        }

        if (id >= min && id <= max) {
            node.getProduct().display();
        }

        if (id < max) {
            rangeSearch(node.getRight(), min, max);
        }

    }
    

    
    
}
