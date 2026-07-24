public class AVLNode {

    int productID;
    String productName;
    double price;
    int quantity;

    int height;

    AVLNode left;
    AVLNode right;


    public AVLNode(int id, String name, double price, int quantity) {

        this.productID = id;
        this.productName = name;
        this.price = price;
        this.quantity = quantity;

        height = 1;
    }
}