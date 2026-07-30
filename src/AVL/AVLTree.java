package AVL;
public class AVLTree {

    AVLNode root;


    int height(AVLNode node){

        if(node == null)
            return 0;

        return node.height;
    }


    int getBalance(AVLNode node){

        if(node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

}