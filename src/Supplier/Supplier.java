package Supplier;

public class Supplier {
    private int supplierId;
    private String name;
    private String company;
    private String phoneNumber;
    private String email;
    private String address;

    public Supplier(int supplierId,String name,String company, String phoneNumber, String email, String address){
        this.supplierId = supplierId;
        this.name = name;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public void displaySupplier(){
        System.out.println("Id:"+supplierId);
        System.out.println("Name:"+name);
        System.out.println("Company:"+company);
        System.out.println("Phone Number:"+phoneNumber);
        System.out.println("Email:"+email);
        System.out.println("Address:"+address);
    }

    // add setter and getter method 
    
}
