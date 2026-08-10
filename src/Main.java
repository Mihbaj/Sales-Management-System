import Product.*;
import java.util.Scanner;
import Employee.*;
import InvoiceSystem.*;


public class Main {
    public static void main(String[] args){
    
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        ProductManager manage= new ProductManager();
        InvoiceManager inManager = new InvoiceManager();
        UserManager userManager = new UserManager();

        System.out.println("----------Login-----------");
        while(true){
            System.out.println("Enter the User Name:");
            String ans =scanner.nextLine();
            if(userManager.search(ans) || userManager.getAdminName().equals(ans)){
                System.out.println("Enter the password:");
                String password = scanner.nextLine();
                if(password==userManager.getPassword(ans) || userManager.getAdminPassword().equals(password)){
                    System.out.println("Permission granted");
                    break;
                }
                else{
                    System.out.println("Invalid Password");
                    return;
                }
            }
            else{
                System.out.println("Invalid User name");
                return;
            }
        }




        while(true){
            System.out.println("------SAMA STORE-----");
            System.out.println("---------------------------");
            System.out.println("1.Customer");
            System.out.println("2.Employee");
            System.out.println("3.Products");
            System.out.println("4.Ivoice:");
            System.out.println("5.Exit");
            
            System.out.println("Enter the Numbr:");
            int choice = scanner.nextInt();

            if(choice==2){
                
                System.out.println("2 Employee");
                System.out.println("2 User");

                Double choice1= scanner.nextDouble();
                if(choice1==2){
                    System.out.println("1.Add Employee");
                    System.out.println("2.Delete Employee");
                    System.out.println("3.Update Employee");
                    
                    System.out.println("Enter the Number:");
                    


                    int choiceEmployee = scanner.nextInt();
                    if(choiceEmployee == 1){
                        
                        manager.addEmployee();
                       
                    }
                    else if(choiceEmployee == 2){
                        manager.deleteEmployee();
                    }
                    else if(choiceEmployee == 3){
                        manager.updateEmployee();

                    }

                    
                }
                else{
                    System.out.println("1.add User");
                    System.out.println("2.Delete User");
                    System.out.println("Enter your choice:");
                    int ans = scanner.nextInt();
                    if(ans ==1){
                        System.out.println("Enter the Employee Id(that who is going to become user):");
                        int id = scanner.nextInt();
                        userManager.createUser(id);
                    }
                    else if(ans ==2){
                        System.out.println("Enter the Employee Id:");
                        int id = scanner.nextInt();
                        userManager.delete(id);
                    }
                }
            }
            else if(choice == 3){
             
                System.out.println("-------Products-------");
                System.out.println("1.Add Product");
                System.out.println("2.");

                System.out.println("Enter the Number:");
                int i = scanner.nextInt();
                
                if(i==1){
                    manage.addProduct();
                }
            }
            else if(choice == 4){
                System.out.println("-------Ivoice------------");
                inManager.createInvoice();
            }

        }
    }
    
}
