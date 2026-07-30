package Sales;

public class Sales {
    private int saleId;
    private String paymentMethod;
    private String paymentStatus;
    private String date;

    public Sales(int saleId,String paymentMethod,String pamentStatus,String date){
        this.saleId = saleId;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.date = date;
    }

    public void displaySales(){
        System.out.println("Sale Id:"+saleId);
        System.out.println("Payment Method:"+paymentMethod);
        System.out.println("Payment Status:"+paymentStatus);
        System.out.println("Date:"+date);
    }
    
}
