package AVL;
import Sales.*;
public class AVLNode {

    int id;
    Sales sales;

    int height;

    AVLNode left;
    AVLNode right;


    public AVLNode(int id,Sales sales) {

        this.id = id;
        this.sales = sales;

        height = 1;
    }
}