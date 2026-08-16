package Item;

public class SaleItem {
    private int itemId;
    private String name;
    private double quantity;
    private double price;

    public SaleItem(String name,double quantity,double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String toFileString(){
        return itemId+":"+name+":"+quantity+":"+price;
    }
    public void display(){
        System.out.println("Item Id:"+itemId);
        System.out.println("Name:"+name);
        System.out.println("Quantinty:"+quantity);
        System.out.println("Price:"+price);
    }
    public void setId(int id){
        itemId = id;
    }

    
}
