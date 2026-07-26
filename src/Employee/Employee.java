package Employee;

public class Employee {
    private int employeeId;
    private String name;
    private String role;
    private String phoneNumber;
    private String email;
    private String address;

    public Employee(int employeeId,String name, String role, String phoneNumber,String email,String address){
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    
    }
    public int getId(){
        return employeeId;
    }
    public String getEmail(){
        return email;
    }

    // create setter and getter method if they are needed

    public void displeyEmployee(){
        System.out.println("ID:"+employeeId);
        System.out.println("Name:"+name);
        System.out.println("Phone Number:"+phoneNumber);
        System.out.println("Email:"+email);
        System.out.println("Address:"+address);
    }

    @Override
    public String toString(){
        return name+","+employeeId+","+role+","+phoneNumber+","+email+","+address;
    }
    
}
