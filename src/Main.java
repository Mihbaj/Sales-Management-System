import Product.*;
import java.util.Scanner;
import Employee.*;

public class Main {
    public static void main(String[] args){

        

    
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("------SAMA STORE-----");
            System.out.println("---------------------------");
            System.out.println("1.Customer");
            System.out.println("2.Employee");
            System.out.println("3.Products");
            System.out.println("4.Exit");
            
            System.out.println("Enter the Numbr:");
            int choice = scanner.nextInt();

            if(choice==2){
                EmployeeManager manager = new EmployeeManager();
                System.out.println("2.1 Employee");
                System.out.println("2.2 User");

                Double choice1= scanner.nextDouble();
                if(choice1==2.1){
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
            }
            else if(choice == 3){
                ProductManager manager = new ProductManager();
                System.out.println("-------Products-------");
                System.out.println("1.Add Product");

                System.out.println("Enter the Number:");
                int i = scanner.nextInt();
                
                if(i==1){
                    manager.addProduct();
                }
            }

        }
    }
    
}
