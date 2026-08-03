package Payment;
import java.util.Scanner;
import Item.*;
import InvoiceSystem.*;

public class Payment {
    private int paymentId;
    private double amount;
    private double blance;
    private String paymentMethod;
    private String paymentStatus;
    private String[] paymentMethodsArray = {"Cash","Card","BankTransfer"};
    private String[] paymentStatusArray = {"Paid","Pending","Partially Paid"};

    public String getMethod(){
        return paymentMethod;
    }
    public String getStatus(){
        return paymentStatus;
    }

    Scanner scanner = new Scanner(System.in);

    public void createPayment(Invoice invoice){
        System.out.println("Payment Methods");
        System.out.println("1.Cash 2.Card 3.Banktranser");
        System.out.println("Enter the Number:");
        int ans = scanner.nextInt();
        for(int i=0;i<paymentMethodsArray.length;i++){
            if(ans == i){
                paymentMethod = paymentMethodsArray[i];
                break;

            }
        }
        System.out.println("Enter the Amount the buyer gave:");
        amount = scanner.nextDouble();
        if(amount == invoice.getTotalAmount()  || amount>invoice.getTotalAmount()){
            paymentStatus = paymentStatusArray[0];
            blance = amount - invoice.getTotalAmount();
        }
        else if(amount <invoice.getTotalAmount()){
            paymentStatus = paymentStatusArray[2];
            blance = invoice.getTotalAmount() - amount;
        }
        else{
            paymentStatus = paymentStatusArray[1];
            blance = invoice.getTotalAmount();
// here i must use total amount;

        }

        
    }
    
}
