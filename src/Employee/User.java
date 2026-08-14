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
    /* 

    public void createUser(int id){ 
        String userName;
        String passWord;
    

        if(manager.searchEmployeeFromList(id)==true){
            
           do{
            System.out.println("Enter the user name:");
            userName = scanner.nextLine();
            if(userTable.search(userName)!= null){
                System.out.println("This user name used already!");
                System.out.println("Do you want to continue(yes/no):");
                String ans = scanner.nextLine();
                if(ans.equalsIgnoreCase("no")){
                    return;
                }
            }

           }
           while(userTable.search(userName)!=null);

           System.out.println("Enter the pasword:");
           passWord = scanner.nextLine();
           
           userTable.insert(userName,passWord);


           


            
            
        }
        else{
            System.out.println("This id not found!");

        }
       
        


        //User user = userTable.search(newUser);

        


    }*/

    


}