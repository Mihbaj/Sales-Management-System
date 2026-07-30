package BST;
import Product.Product;

public class Tree {
    private ProductNode root;

    public Tree(){
        root = null;

    }
    public ProductNode find(int ikey){
        ProductNode current = root;
        
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
        ProductNode newNode = new ProductNode(id,productObj);
       /* newNode.key = id;
        newNode.product= productObj;
        */

        

        if(root == null){
            root = newNode;
        }
        else{
            ProductNode current = root;
            ProductNode parent;
            
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
    public boolean delete (int key){
        ProductNode current = root;
        ProductNode parent = root;
        boolean isLeftChild = true;

        while (current.key != key){
            parent = current;
            if(key<current.key){
                isLeftChild = true;
                current = current.leftChild;
            }
            else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null){
                return false;
            }
        }

        if(current == null){
            return false;
        }

        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }
            else if(isLeftChild) {
                parent.leftChild = null;
            }
            else{
                parent.rightChild = null;

            }
        }
        else if(current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }
            else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }
            else{
                parent.rightChild = current.leftChild;
            }
        }
        else if(current.leftChild==null){
            if(current== root){
                root = current.rightChild;
            }
            else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }
            else {
                parent.rightChild = current.rightChild;
            }
        
        }
        else {
            ProductNode successor = getSuccessor(current);

            if(current == root){
                root = successor;
            }
            else if( isLeftChild){
                parent.leftChild = successor;
            }
            else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private ProductNode getSuccessor(ProductNode deleteNode){
        ProductNode successorParent = deleteNode;
        ProductNode successor = deleteNode;

        ProductNode current = deleteNode.rightChild;

        while (current != null){
            successorParent = successor;
            successor  = current;

            current = current.leftChild;
        }
        if (successor != deleteNode.rightChild){
            successorParent.leftChild= successor.rightChild;

            successor.rightChild = deleteNode.rightChild;
        }
        return successor;

    }
    
}
