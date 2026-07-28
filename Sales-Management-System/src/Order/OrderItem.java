package Order;

public class OrderItem {

    private int orderItemId;
    private int productId;
    private String productName;
    private double unitPrice;
    private int quantity;
    private double discount;

    public OrderItem(int orderItemId, int productId, String productName,
                     double unitPrice, int quantity, double discount) {

        this.orderItemId = orderItemId;
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
    }

    public double calculateTotalPrice() {
        return (unitPrice * quantity) - discount;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void displayOrderItem() {
        System.out.println("Order Item ID : " + orderItemId);
        System.out.println("Product ID    : " + productId);
        System.out.println("Product Name  : " + productName);
        System.out.println("Unit Price    : " + unitPrice);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Discount      : " + discount);
        System.out.println("Total Price   : " + calculateTotalPrice());
    }
}