package Item;
import Product.*;

public class Item {
    private int itemId =0;
    private Product product;
    private double quntity;
    private int nItem=1;

    public Item( Product product,double quntity){
        itemId=itemId+nItem;
        this.product = product;
        this.quntity = quntity;
        nItem+=1;
        // i want to create a txt file for nItem and update the number - i think don't need

    }
    public void displyItem(){
        System.out.println("Item Id:"+itemId);
       
        System.out.println("Quntity:"+quntity);

    }
    // when add a Item first, we chacke it in the product List
    
    
}
