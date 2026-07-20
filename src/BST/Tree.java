package BST;
import Product.Product;

public class Tree {
    private Node root;

    public Tree(){
        root = null;

    }
    public Node find(int ikey){
        Node current = root;
        
        while(current.key != ikey){
            if(ikey < current.key){
                current = current.leftChild;
                if(current == null){
                    return null;
                }
            }
            else{
                current = current.rightChild;
                if(current == null){
                    return null;
                }
            }


        } 
        return current;
    }
    public void insert(int id,Product productObj){
        Node newNode = new Node();
        newNode.key = id;
        newNode.product= productObj;

        if(root == null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent;
            
            while (true){
                parent = current;
                if(id<current.key){
                    current = current.leftChild;
                    if(current== null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }
    
}
