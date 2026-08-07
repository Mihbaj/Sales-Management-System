package Item;

public class SaleItem {
    private String name;
    private double quantity;
    private double price;

    public SaleItem(String name,double quantity,double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String toFileString(){
        return name+":"+quantity+":"+price;
    }

    
}
