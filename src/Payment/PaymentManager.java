package Payment;

import java.util.Scanner;

import HashTable.HashTable;
import InvoiceSystem.*;
import FileHandaling.*;
import LinkList.*;
import SortingAlgorithams.*;

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
    public void search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Payment Id:");
        String searchId =sc.nextLine();
        Payment payment = paymentTable.search(searchId);
        if(payment == null){
            System.out.println("This Payment id is not exit");
            return;

        }
        payment.displayPayment();

    }
    public void displayAll(){
        Sorting<String> sorting = new Sorting<>();
        LinkList<Payment> list =paymentTable.returnAll();
        String[] array = new String[list.length()];
        int index=0;
        LinkNode<Payment> current = list.getFirst();
        if(current==null){
            System.out.println("No order");
            return;
        }
    
        while(current!=null){
            array[index]= current.getData().getId();
            index ++;
            current = current.getNext();
        }
        sorting.quickSort(array,0,array.length-1);
        for(int i = 0;i<array.length;i++){
            Payment payment = paymentTable.search(array[i]);
            if(payment!=null){
                payment.displayPayment();
            }
        }
        

    }

    
}
