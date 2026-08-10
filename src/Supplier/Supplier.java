package Supplier;
import LinkList.*;

public class Supplier {
    private int supplierId;
    private String name;
    private String company;
    private String phoneNumber;
    private String email;
    private String address;
    private LinkList<String> productNames = new LinkList<>();


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
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
       
        LinkNode<String> current = productNames.getFirst();
        while(current!=null){
            builder.append(current.getData());
            
            current = current.getNext();
            if(current!=null){
                builder.append(":");
            }
        }
        String names = builder.toString();
        return supplierId+","+name+","+company+","+phoneNumber+","+email+","+address+","+names;
    }
    public  int getId(){
        return supplierId;
    }
    public void setId(int id){
        supplierId = id;
    }
    public void setName(String name){
        this.name = name ;
    }
    public String getName(){
        return name;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPhoneNumber(String number){
        phoneNumber = number;
    }
    public void addProductName(String name){
        productNames.add(name);

    }
    

    // add setter and getter method 
    
}
