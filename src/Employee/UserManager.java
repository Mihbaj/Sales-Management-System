package Employee;
import java.util.Scanner;
import HashTable.HashTable;
import FileHandaling.UserFile;
import Employee.UserManager;


public class UserManager {
    final private String adminName = "admin";
    final private String adminPassword= "admin1234";


    public static HashTable<String,String> userTable = new HashTable<>();
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

           }
           while(userTable.search(userName)!=null);

           System.out.println("Enter the pasword:");
           passWord = scanner.nextLine();
           User newUser = new User();
           newUser.setUserName(userName);
           newUser.setPassword(passWord);
           
           userTable.insert(userName,passWord);
           usermanager.write(newUser);
           Employee employee = manager.search(id);
           if(employee!=null){
            employee.setUserName(userName);
            manager.rewriteFile(id);
            manager.fileWrite(employee);


           }
           
  
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
                employee.setUserName(null);
                
                User user = new User();
                user.setUserName(employee.getUserName());
                user.setPassword(userTable.search(user.getUserName()));
               
                userTable.delete(user.getUserName());
                usermanager.updateFile(user);
                
                
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
            if(name=="admin"){
                System.out.println("Enter Password:");
                String password = scanner.nextLine();
                if(password=="admin1234"){
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
        String word = userTable.search(userName);
        return word;
    }

    
}
