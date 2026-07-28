package Item;

public class Item {
    private int itemId;
    private String name;
    private double quntity;

    public Item(int itemId, String name,double quntity){
        this.itemId = itemId;
        this.name = name;
        this.quntity = quntity;

    }
    public void displyItem(){
        System.out.println("Item Id:"+itemId);
        System.out.println("Name:"+name);
        System.out.println("Quntity:"+quntity);

    }
    // when add a Item first, we chacke it in the product List
    
    
}
