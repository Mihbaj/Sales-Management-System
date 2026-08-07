package Item;
import Product.*;

public class Item {
    private int itemId;
    private Product product;
    private double quntity;
   
    private double price;

    public Item( Product product,double quntity){
        
        this.product = product;
        this.quntity = quntity;
        price = (product.getSellingPrice()*quntity);
        
        // i want to create a txt file for nItem and update the number - i think don't need

    }
    public void displayItem(){
        System.out.println("Item Id:"+itemId);
        System.out.println("Item Name:"+product.getName()+", product ID:"+product.getId());
        System.out.println("unint price:"+product.getSellingPrice());
        System.out.println("Quntity:"+quntity);
        System.out.println("Price:"+price);

    }
    public double getPrice(){
        return price;
        
    }
    public int getitemId(){
        return itemId;
    }
    public void setId(int nitem){
        itemId = nitem+1;

    }
    public String getProductName(){
        return product.getName();

    }
    public double getQuntity(){
        return quntity;
    }
    
    
    
    // when add a Item first, we chacke it in the product List
    
    
}
