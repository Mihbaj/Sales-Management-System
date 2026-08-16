package BST;
import Product.Product;

public class ProductNode {
    public int key;
    public Product product;
    public ProductNode leftChild;
    public ProductNode rightChild;

    public ProductNode(int key,Product product){
        this.key = key;
        this.product = product;
        this.leftChild = null;
        this.rightChild = null;
    }
    public Product getProduct(){
        return product;
    }
    public ProductNode getLeft(){
        return leftChild;
    }
    public ProductNode getRight(){
        return rightChild;
    }

    public void displayNode(){
        
    }

    
}
