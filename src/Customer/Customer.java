 package Customer;

import Employee.User;

public class Customer {
    private int customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Customer(int customerId,String name,String phoneNumber,String email,String address){
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    
    public  int getId(){
        return customerId;
    }
    public void setId(int id){
        customerId = id;

    }
    public void setName(String name){
        this.name = name;
    
    }
    public String getName(){
        return name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber= phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public String getEmail(){
        return email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    public void displayCustomer(){
        System.out.println("Id:"+customerId);
        System.out.println("Name:"+name);
        System.out.println("Phone Number:"+phoneNumber);
        System.out.println("Email:"+email);
        System.out.println("Address:"+address);

    }
    @Override
    public String toString(){
        return customerId+","+name+","+phoneNumber+","+email+","+address;

    }
  
  
    
}
