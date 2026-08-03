package Product;

public class Product {
    private int productId;
    private String name;
    // add category
    private double sellingPrice;
    private double costPrice;
    private double quantity;
    private int reorderLevel;
    //add sublierId

    public Product(int productId,String name, double sellingPrice, double costPrice,double quantity,int reorderLevel){
        this.productId = productId;
        this.name = name;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;


    }
    public int getId(){
        return productId;
    }
    public double getSellingPrice(){
        return sellingPrice;
    }
    // set getter and setter

    @Override 
    public String toString(){
        return productId+","+name+","+sellingPrice+","+costPrice+","+quantity+","+reorderLevel;
    }
    


    
}
