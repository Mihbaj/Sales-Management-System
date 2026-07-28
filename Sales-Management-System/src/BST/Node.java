package BST;
import Product.Product;

public class Node {
    public int key;
    public Product product;
    public Node leftChild;
    public Node rightChild;

    public Node(int key,Product product){
        this.key = key;
        this.product = product;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void displayNode(){
        
    }

    
}
