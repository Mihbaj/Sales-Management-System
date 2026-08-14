package Employee;
import java.util.Scanner;
import HashTable.HashTable;
import FileHandaling.UserFile;
import Employee.UserManager;


public class UserManager {
    final private String adminName = "admin";
    final private String adminPassword= "admin1234";


    public static HashTable<String,User> userTable = new HashTable<>();
    EmployeeManager manager = new EmployeeManager();
    UserFile usermanager = new UserFile();

    boolean fileload=true;

    public UserManager(){
        
        if(fileload){
            usermanager.reader();
            fileload = false;
        }

    }
    public String getAdminName(){
        return adminName;
    }
    public String getAdminPassword(){
        return adminPassword;
    }



    public void createUser(int id){ 
        
        Scanner scanner = new Scanner(System.in);
        String userName;
        String passWord;
        verification();

       
    

        if(manager.search(id)!=null){
            
            
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

           } while(userTable.search(userName)!=null);

           System.out.println("Enter the pasword:");
           passWord = scanner.nextLine();
           User newUser = new User();
           newUser.setUserName(userName);
           newUser.setPassword(passWord);
           newUser.setEmployeeId(id);
           
           userTable.insert(userName,newUser);
           usermanager.write(newUser);
           Employee employee=manager.search(id);
           employee.setUserName(userName);
           manager.rewriteFile(id);
           manager.fileWrite(employee);
           
           
           
  
        }
        else{
            System.out.println("This id not found!");

        }
        //User user = userTable.search(newUser);


    }
    public void delete(int id){
        verification();
        if(manager.search(id)!=null){
            if(manager.search(id).getUserName()!=null){
                
                Employee employee = manager.search(id);
                User deleteUser =userTable.search(employee.getUserName());
                usermanager.updateFile(deleteUser);
                userTable.delete(employee.getUserName());
               
                employee.setUserName(null);
                manager.rewriteFile(id);
                manager.fileWrite(employee);

                
                
                
                



            }
            
            
        }

    }
    public  void verification(){
        
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter the Admim Name:");
            String name = scanner.nextLine();
            if(name.equals("admin")){
                System.out.println("Enter Password:");
                String password = scanner.nextLine();
                if(password.equals("admin1234")){
                    System.out.println("Permission granted");
                    break;
                }
                else{
                    System.out.println("Invalid password");
                    System.out.println("Do you want to continue(yes/no)");
                    String ans = scanner.nextLine();
                    if(ans.equalsIgnoreCase("no")){
                        return;
                    }
                    else if(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")){
                        System.out.println("Invalid Input");
                        return;


                    }
                }

            }
            else{
                System.out.println("Invalid Admin.");
                
                System.out.println("Do you want to continue(yes/no)");
                String ans = scanner.nextLine();
                if(ans.equalsIgnoreCase("no")){
                    return;
                }
                else if(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")){
                    System.out.println("Invalid Input");
                    return;


                }
            }

        }
    }
    public boolean search(String username){
        if(userTable.search(username)!=null){
            return true;
        }
        return false;//so password can be null
    }
    public String  getPassword(String userName){
        User user = userTable.search(userName);
        String password = user.getPassword();
        return password;
    }

    
}
