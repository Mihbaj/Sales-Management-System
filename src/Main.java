import Product.*;
import java.util.Scanner;
import Employee.*;
import InvoiceSystem.*;
import Order.*;
import Sales.*;
import Payment.PaymentManager;
import Customer.CustomerManager;
import StackAndQueue.Stacknew;
import Supplier.SupplierManager;
import BST.ProductNode;


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
        SupplierManager suppliermanager = new SupplierManager();
        Stacknew recent = new Stacknew();

        System.out.println("----------Login-----------");
        while(true){
            System.out.println("Enter the User Name:");
            String ans =scanner.nextLine();
            if(userManager.getAdminName().equals(ans)){
                System.out.println("Enter the password:");
                String password = scanner.nextLine();
                if(userManager.getAdminPassword().equals(password)){
                    System.out.println("Permission granted");
                    break;
                }
                else{
                    System.out.println("Invalid Password");
                    return;
                }
            }
            
            else if(userManager.search(ans)){
                System.out.println("Enter the Password:");
                String password = scanner.nextLine();
                if(password.equals(userManager.getPassword(ans))){
                    System.out.println("Permission granted");
                    break;

                }
                else{
                    System.out.println("Invalid password");
                    return;
                }


            }
            else{
                System.out.println("Invalid UserName");
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
            System.out.println("8.Suplier");
            System.out.println("9.resent Activites");
            System.out.println("10.Exit");
            
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
                    System.out.println("4.Search Employee");
                    System.out.println("5.Display All Employee");
                    System.out.println("6.Exit");
                    
                    System.out.println("Enter the Number:");
                    


                    int choiceEmployee = scanner.nextInt();
                    if(choiceEmployee == 1){
                        recent.addActivite("Add Employee");
                        manager.addEmployee();
                       
                    }
                    else if(choiceEmployee == 2){
                        recent.addActivite("Delete Employee");
                        manager.deleteEmployee();
                    }
                    else if(choiceEmployee == 3){
                         recent.addActivite("Update Employee");
                        manager.updateEmployee();

                    }
                    else if(choiceEmployee==4){
                        recent.addActivite("Search Employee");
                        manager.search();
                    }
                    else if(choiceEmployee==5){
                        recent.addActivite("Display All Employee");
                        manager.displayAll();

                    }
                    else if(choiceEmployee==6){
                        System.out.println("Exit...");
                    }
                    else{
                        System.out.println("Invalid Input");
                    }

                    
                }
                else if(choice1==2){
                    System.out.println("1.add User");
                    System.out.println("2.Delete User");
                    System.out.println("3.Display All User");
                    System.out.println("4.Exit");
                    System.out.println("Enter your choice:");
                    int ans = scanner.nextInt();
                    if(ans ==1){
                         recent.addActivite("Add User");
                        System.out.println("Enter the Employee Id(that who is going to become user):");
                        int id = scanner.nextInt();
                        userManager.createUser(id);
                    }
                    else if(ans ==2){
                        recent.addActivite("Delte User");

                        System.out.println("Enter the Employee Id:");
                        int id = scanner.nextInt();
                        userManager.delete(id);
                    }
                    else if(ans==3){
                        recent.addActivite("Display All User");
                        userManager.displayAll();

                    }
                    else if(ans ==4){
                        System.out.println("Exit....");

                    }
                    else{
                        System.out.println("Invalid Input");
                    }
                }
            }
            else if(choice == 3){
             
                System.out.println("-------Products-------");
                System.out.println("1.Add Product");
                System.out.println("2.Update Product");
                System.out.println("3.Delete Product");
                System.out.println("4.Search Prodcut");
                System.out.println("5.Display All Product");
                System.out.println("6.Search Products(Between Range)");
                System.out.println("7.Exit");

                System.out.println("Enter the Number:");
                int i = scanner.nextInt();
                scanner.nextLine();
                
                if(i==1){
                    recent.addActivite("Add Product");
                    productmanage.addProduct();
                }
                else if(i==2){
                    recent.addActivite("Update Product");
                    productmanage.updateProduct();
                }
                else if(i==3){
                    recent.addActivite("Delete Product");
                    productmanage.deleteProduct();
                }
                else if(i==4){
                    recent.addActivite("Search Product");
                    productmanage.search();
                }
                else if(i==5){
                    recent.addActivite("Display All Product");
                    productmanage.displayAll();
                }
                else if(i==7){
                    System.out.println("Exit....");
                }
                else if(i==6){
                    recent.addActivite("Search Products(Between Range)");
                    ProductNode root =ProductManager.tree.getRoot();
                    System.out.println("Enter the start Id:");
                    int startId = scanner.nextInt();
                    System.out.println("Enter the End Id:");
                    int endId = scanner.nextInt();
                    productmanage.rangeSearch(root,startId,endId);
                }
                else{
                    System.out.println("Invalid Input");
                }
            }
            else if(choice == 4){
                recent.addActivite("Ivoice");
                System.out.println("-------Ivoice------------");
                inManager.createInvoice();
            }
            else if (choice ==5){
                System.out.println("-----------Order-------------");
                System.out.println("1.Add Order");
                System.out.println("2.View next Order");
                System.out.println("3.Cencel Order");
                System.out.println("4.Delete Order(from Queue)");
                System.out.println("5.Display All Order");
                System.out.println("6.Exit");
                
                System.out.println("Enter your choice:");
                int i =scanner.nextInt();

                if(i==1){
                    recent.addActivite("Add Order");
                    orderManager.createOrder();
                    

                }
                else if(i==2){
                    recent.addActivite("View Order");
                    orderManager.getNextOrder();
                }
                else if(i==3){
                    recent.addActivite("Cancel Order");
                    orderManager.cancelOrder();
                }
                else if(i==4){
                    recent.addActivite("Delete Order");
                    orderManager.removeOrder();
                }
                else if(i==5){
                    recent.addActivite("Display All Order");
                    orderManager.displayAll();
                }
                else if(i==6){
                    System.out.println("Exit....");
                }
                else{
                    System.out.println("Invalid Input");
                    


                }
            }
            else if(choice ==6){
                Scanner sc  = new Scanner(System.in);
                System.out.println("--------------Sales----------------");
                System.out.println("1.View Sale");
                System.out.println("2.Display All ");
                System.out.println("3.Exit");
                System.out.println("Enter your choice:");
                int i =sc.nextInt();
                if(i==1){
                    recent.addActivite("View Sale");
                    salemanager.search();

                }
                else if(i==2){
                    recent.addActivite("Display All");
                    salemanager.displayAll();
                }
                else if(i ==3){
                    System.out.println("Exit...");
                }
                else{
                    System.out.println("Invalid Input");
                }



            }
            else if(choice ==7){
                Scanner sc  = new Scanner(System.in);
                System.out.println("-------Payment------");
                System.out.println("1.view payment");
                System.out.println("2.Display All Payment");
                System.out.println("3.Exit");
                System.out.println("Entetr your choice:");
                int ans = sc.nextInt();
                if(ans==1){
                    recent.addActivite("view payment");
                    paymentmanager.search();

                }
                else if(ans==2){
                    recent.addActivite("Display All Payment");
                    paymentmanager.displayAll();
                }
                else if(ans==3){
                    System.out.println("Exit.....");
                }
                else{
                    System.out.println("Invalid Input");
                }


            }
            else if(choice ==1){
                Scanner sc  = new Scanner(System.in);
                System.out.println("----------Customer----------");
                System.out.println("1.Add Customer");
                System.out.println("2.Delete Custeomer");
                System.out.println("3.Update Customer");
                System.out.println("4.Search Customer");
                System.out.println("5.Display All Employee");
                System.out.println("6.Exit");
                System.out.println("Enter your choice:");
                int ans = sc.nextInt();
                if(ans ==1){
                    recent.addActivite("Add Customer");
                    customermanager.createCustomer();

                }
                else if(ans==2){
                    recent.addActivite("Delete Customer");
                    customermanager.deleteCustomer();
                }
                else if(ans ==3){
                    recent.addActivite("Update Customer");
                    customermanager.updateCustomer();
                }
                else if(ans ==4){
                    recent.addActivite("Search Customer");
                    customermanager.search();

                }
                else if(ans ==5){
                    recent.addActivite("Display All Customer");
                    customermanager.displayAll();
                }
                else if(ans ==6){
                    System.out.println("Exit....");
                }
                else{
                    System.out.println("Invalid input");
                    
                }

            }
            else if(choice ==9){
                Scanner sc = new Scanner(System.in);
                System.out.println("--------Recent Activites--------");
                System.out.println("1.view last acitive");
                System.out.println("2.Delte last activite");
                System.out.println("3.Delete All");
                System.out.println("4.Exit");
                System.out.println("Enter your choice:");
                int ans = sc.nextInt();
                if(ans ==1){
                    recent.peek();
                }
                else if(ans ==2){
                    recent.deleteActivite();
                }
                else if(ans ==3){
                    recent.deleteAll();
                }
                else if(ans ==4){
                    System.out.println("Exit...");
                }
                else{
                    System.out.println("Invalid input");
                    
                }
            }
            else if(choice ==8){
                Scanner sc = new Scanner(System.in);
                System.out.println("--------Supplier-------");
                System.out.println("1.Add Supplier");
                System.out.println("2.Update Suppleir");
                System.out.println("3.Delete Supplier");
                System.out.println("4.Display All Supplier");
                System.out.println("5.View The Products Of Supplier");
                System.out.println("6.Display Suppliers Of A Product");
                System.out.println("7.Exit");
                System.out.println("Enter your choice:");
                int ans = sc.nextInt();
                if(ans==4){
                    recent.addActivite("Display All Supplier");
                    suppliermanager.displaySupplierAndProduct();

                }
                else if(ans==1){
                    recent.addActivite("Add Supplier");
                    suppliermanager.createSupplier();
                }
                else if(ans==2){
                    recent.addActivite("Update Supplier");
                    suppliermanager.updateSupplier();
                }
                else if(ans ==3){
                    recent.addActivite("Delete Supplier");
                    suppliermanager.deleteSupplier();
                }
                else if(ans ==5){
                    recent.addActivite("View The Products Of Supplier");
                    suppliermanager.displayProductsOfSupplier();
                }
                else if(ans==6){
                    recent.addActivite("Display Suppliers Of A Product");
                    suppliermanager.getProductSuppliers();
                }
                else if(ans==7){
                    System.out.println("Exit....");
                }
                else{
                    System.out.println("Invalid Input");
                }
                

            }
            else if(choice==10){
                System.out.println("Exit...");
                return;
            }
            else{
                System.out.println("Invalid Input");
                return;
            }


        }
    }
    
}
