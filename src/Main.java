import Product.*;
import java.util.Scanner;
import Employee.*;
import InvoiceSystem.*;
import Order.*;
import Sales.*;
import Payment.PaymentManager;
import Customer.CustomerManager;


public class Main {
    public static void main(String[] args){
    
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        ProductManager productmanage= new ProductManager();
        InvoiceManager inManager = new InvoiceManager();
        UserManager userManager = new UserManager();
        OrderManager orderManager = new OrderManager();
        SalesManager salemanager = new SalesManager();
        PaymentManager paymentmanager = new PaymentManager();
        CustomerManager customermanager = new CustomerManager();

        System.out.println("----------Login-----------");
        while(true){
            System.out.println("Enter the User Name:");
            String ans =scanner.nextLine();
            if(userManager.search(ans) || userManager.getAdminName().equals(ans)){
                System.out.println("Enter the password:");
                String password = scanner.nextLine();
                if(password.equals(userManager.getPassword(ans)) || userManager.getAdminPassword().equals(password)){
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
            System.out.println("5.Order");
            System.out.println("6.Sales");
            System.out.println("7.Payment");
            System.out.println("5.Exit");
            
            System.out.println("Enter the Numbr:");
            int choice = scanner.nextInt();

            if(choice==2){
                
                System.out.println("1.Employee");
                System.out.println("2.User");

                Double choice1= scanner.nextDouble();
                if(choice1==1){
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
                System.out.println("2.Update Product");

                System.out.println("Enter the Number:");
                int i = scanner.nextInt();
                
                if(i==1){
                    productmanage.addProduct();
                }
                else if(i==2){
                    productmanage.updateProduct();
                }
            }
            else if(choice == 4){
                System.out.println("-------Ivoice------------");
                inManager.createInvoice();
            }
            else if (choice ==5){
                System.out.println("-----------Order-------------");
                System.out.println("1.Add Order");
                System.out.println("2.View next Order");
                System.out.println("3.Cencel Order");
                System.out.println("4.Delete Order(from Queue)");
                System.out.println("5.Exit");
                
                System.out.println("Enter your choice:");
                int i =scanner.nextInt();

                if(i==1){
                    orderManager.createOrder();
                    

                }
                else if(i==2){
                    orderManager.getNextOrder();
                }
                else if(i==3){
                    orderManager.cancelOrder();
                }
                else if(i==4){
                    orderManager.removeOrder();
                }
                else if(i==5){
                    return;
                }
                else{
                    System.out.println("Invalid Input");
                    return;


                }
            }
            else if(choice ==6){
                Scanner sc  = new Scanner(System.in);
                System.out.println("--------------Sales----------------");
                System.out.println("1.View Sale");
                System.out.println("Enter your choice:");
                int i =sc.nextInt();
                if(i==1){
                    salemanager.search();

                }


            }
            else if(choice ==7){
                Scanner sc  = new Scanner(System.in);
                System.out.println("-------Payment------");
                System.out.println("1.view payment");
                System.out.println("Entetr your choice:");
                int ans = sc.nextInt();
                if(ans==1){
                    paymentmanager.search();

                }


            }
            else if(choice ==1){
                Scanner sc  = new Scanner(System.in);
                System.out.println("----------Customer----------");
                System.out.println("1.Add Customer");
                System.out.println("2.Delete Custeomer");
                System.out.println("3.Update Customer");
                System.out.println("Enter your choice:");
                int ans = sc.nextInt();
                if(ans ==1){
                    customermanager.createCustomer();

                }
                else if(ans==2){
                    customermanager.deleteCustomer();
                }
                else if(ans ==3){
                    customermanager.updateCustomer();
                }

            }


        }
    }
    
}
