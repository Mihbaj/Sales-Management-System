package Sales;
import java.util.ArrayList;
import Item.*;
import FileHandaling.*;
import AVL.*;
import java.time.LocalDate;
import java.util.Scanner;




public class SalesManager {
    SalesFiles manager = new SalesFiles();
    static public AVLTree tree = new AVLTree();
    

    private static boolean fileload = true;

    public SalesManager(){
        if(fileload){
            manager.reader();
            fileload = false;

        }
      

    }

    public void createSale(String id,String method,String status,LocalDate date,ArrayList<SaleItem> list){
        Sales sale = new Sales(id,method,status,date,list);
     
        manager.write(sale);
        tree.insert(sale.getTreeId(),sale);
        

        
    }
    public void search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sale id:");
        String id = sc.nextLine();

        int searchId =Integer.parseInt(id.substring(2));
        Sales sale = tree.search(searchId);
        if(sale == null){
            System.out.println("This sale id is not exit");
            return;
        }
        sale.displaySales();
    }


    
}
