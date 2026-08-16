package Employee;
import java.util.Scanner;
import HashTable.*;


public class User{
    Scanner scanner = new Scanner(System.in);
    EmployeeManager manager = new EmployeeManager();
    

    private String username;
    private String password;
    private int employeeId;
    

    

    public void setUserName(String username){
        this.username = username;
    }
    public String  getUserName(){
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setEmployeeId(int id){
        employeeId = id;
    }
    @Override
    public String toString(){
        return username+","+password+","+employeeId;

    }
    public void display(){
        System.out.println("Emlployee Id:"+employeeId);
        System.out.println("User Name:"+username);
        System.out.println("Password:"+password);
        System.out.println();
    }
    
    


}