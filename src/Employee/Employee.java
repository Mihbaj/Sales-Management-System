package Employee;
import java.util.Scanner;

public class Employee {
    private int employeeId;
    private String name;
    private String role;
    private String phoneNumber;
    private String email;
    private String address;
    private String userName=null;

    Scanner scanner = new Scanner(System.in);

    public Employee(int employeeId,String name, String role, String phoneNumber,String email,String address){
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        
    
    }
    public void setId(int id){
        employeeId = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setRole(String role){
        this.role = role;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getId(){
        return employeeId;
    }
    public String getEmail(){
        return email;
    }
    public void setUserName(String name){
        userName = name;
    }
    public String getUserName(){
        return userName;

    }

    // create setter and getter method if they are needed

    public void displayEmployee(){
        System.out.println("ID:"+employeeId);
        System.out.println("Name:"+name);
        System.out.println("Role:"+role);
        System.out.println("Phone Number:"+phoneNumber);
        System.out.println("Email:"+email);
        System.out.println("Address:"+address);
    }

    @Override
    public String toString(){
        return name+","+employeeId+","+role+","+phoneNumber+","+email+","+address;
    }
    @Override 
    public boolean equals(Object obj){
        if(!(obj instanceof Employee)){
            System.out.println("This is not a Employee");
            return false;
        }
        Employee employee = (Employee) obj;
        return this.employeeId == employee.getId();

    }
    
    
}
