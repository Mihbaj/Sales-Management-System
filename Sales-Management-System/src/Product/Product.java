package Product;

public class Product {
    private int productId;
    private String name;
    // add category
    private double sellingPrice;
    private double costPrice;
    private int quantity;
    private int reorderLevel;
    //add sublierId

    public Product(int productId,String name, double sellingPrice, double costPrice,int quantity,int reorderLevel){
        this.productId = productId;
        this.name = name;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;


    }
    // set getter and setter


    
}
