package Item;
import Product.*;

public class Item {
    private int itemId =0;
    private Product product;
    private double quntity;
    private int nItem=1;
    private double price;

    public Item( Product product,double quntity){
        itemId=itemId+nItem;
        this.product = product;
        this.quntity = quntity;
        price = (product.getSellingPrice()*quntity);
        nItem+=1;
        // i want to create a txt file for nItem and update the number - i think don't need

    }
    public void displyItem(){
        System.out.println("Item Id:"+itemId);
       
        System.out.println("Quntity:"+quntity);

    }
    public double getPrice(){
        return price;
        
    }
    
    
    // when add a Item first, we chacke it in the product List
    
    
}
