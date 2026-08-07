package Payment;



public class Payment {
    private String paymentId;
    private double amount;
    private double balance;
    private String paymentMethod;
    private String paymentStatus;
    private int lastPaymentNumber;
    
    //public int lastPaymentNumber=1;

    public Payment(double amount,double balance,String paymentMethod,String paymentStatus){
       
        this.amount =amount;
        this.balance=balance;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        
        //lastPaymentNumber+=1;

    }
    public void setLastPayment(int number){
        lastPaymentNumber=number;
    }
   

    public String getMethod(){
        return paymentMethod;
    }
    public double getBalance(){
        return balance;
    }
    public String getStatus(){
        return paymentStatus;
    }
    public String getId(){
        return paymentId;
    }
    public void setId(int lastNumber){
        paymentId = "PM"+(lastNumber+1);
        lastPaymentNumber=lastNumber+1;
    }
    public void setId(String id){
        paymentId = id;
    }
    public int getLastPaymentNumber(){
        return lastPaymentNumber;
    }
    public void displayPayment(){
        System.out.println("Payment Id:"+paymentId);
        System.out.println("Method:"+paymentMethod);
        System.out.println("Paid Amound:"+amount);
        System.out.println("Balance:"+balance);
        System.out.println("Status:"+paymentStatus);

    }
    

    
        


        
    
    @Override
    public String toString(){
        return paymentId+","+amount+","+balance+","+paymentMethod+","+paymentStatus+","+lastPaymentNumber;
    }

    
}
