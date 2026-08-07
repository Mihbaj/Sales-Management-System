package Payment;

import java.util.Scanner;

import HashTable.HashTable;
import InvoiceSystem.*;
import FileHandaling.*;

public class PaymentManager {
    
    Scanner scanner = new Scanner(System.in);
    static public HashTable<String,Payment> paymentTable = new HashTable<>();
    //int lastPaymentNumber;
    private static boolean fileload = true;
    PaymentFile manager = new PaymentFile();
    static public int lastNumber;
    public PaymentManager(){
        if(fileload){
            manager.reader();
            fileload = false;

        }
        

    }

    

    public Payment createPayment(Invoice invoice){
        String[] paymentMethodsArray = {"Cash","Card","BankTransfer"};
        String[] paymentStatusArray = {"Paid","Pending","Partially Paid"};
        String paymentMethod;
        String paymentStatus;
        double balance;
        double amount;
        System.out.println("Payment Methods");
        System.out.println("1.Cash 2.Card 3.Banktranser");
        System.out.println("Enter the Number:");
        int ans = scanner.nextInt();
        while(ans<1||ans>paymentMethodsArray.length){
            System.out.println("Invalid payment method");
            System.out.println("Enter a number from 1 to 3:");
            ans = scanner.nextInt();


        }
        paymentMethod = paymentMethodsArray[ans-1];

        System.out.println("Enter the Amount the customer gave:");
        amount = scanner.nextDouble();
       while(amount<0){
        System.out.println("Amount can not be negative.");
        System.out.println("Enter the amount again:");
        amount = scanner.nextDouble();
       }

       if(amount>=invoice.getTotalAmount()){
        paymentStatus = paymentStatusArray[0];
        balance= amount-invoice.getTotalAmount();
       }
       else if(amount>0){
        paymentStatus = paymentStatusArray[2];
        balance= invoice.getTotalAmount()-amount;
        
       }
       else{
        paymentStatus = paymentStatusArray[1];
        balance= invoice.getTotalAmount();
       }
        Payment payment = new Payment(amount,balance,paymentMethod,paymentStatus);
        payment.setId(lastNumber);
        lastNumber = payment.getLastPaymentNumber();
        paymentTable.insert(payment.getId(),payment);
        manager.write(payment);

       
        return payment;


    }

    
}
