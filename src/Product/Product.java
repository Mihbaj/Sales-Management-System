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
    public void setId(int id){
        productId =id;

    }
    public void setName(String name){
        this.name = name;
    }
    public void setSellingPrice(double price){
        sellingPrice = price;
    }
    public void setCostPrice(double price){
        costPrice = price;
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
    public double getCostPrice(){
        return costPrice;
    }
    
    // set getter and setter

    @Override 
    public String toString(){
        return productId+","+name+","+sellingPrice+","+costPrice;
    }
    public void display(){
        System.out.println("Product Id:"+productId);
        System.out.println("Name:"+name);
        System.out.println("Cost Price:"+costPrice);
        System.out.println("Selling Price:"+sellingPrice);
      
    }
    


    
}
