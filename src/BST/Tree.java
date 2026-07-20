package BST;

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
    public void insert(int id,double dd){
        Node newNode = new Node();
        newNode.key = id;
        // here we must give the object

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
