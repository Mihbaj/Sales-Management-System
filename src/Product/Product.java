package Product;

public class Product {
    private int productId;
    private String name;
    // add category
    private double sellingPrice;
    private double costPrice;
    
   
    //add sublierId

    public Product(int productId,String name, double sellingPrice, double costPrice){
        this.productId = productId;
        this.name = name;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
        
      


    }
    public int getId(){
        return productId;
    }
    public double getSellingPrice(){
        return sellingPrice;
    }
    public String getName(){
        return name;
    }
    // set getter and setter

    @Override 
    public String toString(){
        return productId+","+name+","+sellingPrice+","+costPrice;
    }
    


    
}
