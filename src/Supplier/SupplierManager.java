package Supplier;

import java.util.Scanner;

import Customer.Customer;
import FileHandaling.*;
import HashTable.HashTable;
import Graph.Graph;
import LinkList.*;

public class SupplierManager {
    static public HashTable<Integer,Supplier> supplierTable = new HashTable<>();
    SuplierFile suppliermanager = new SuplierFile();
    public static Graph<String> graph = new Graph<>();
    

    boolean fileload=true;
    public SupplierManager(){
        if(fileload){
            suppliermanager.reader();
            fileload = false;
        }
    }
    

    public void createSupplier(){
        String productName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the following Details");
        System.out.println("ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Company:");
        String company = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Address(Do not use coma/,):");
        String address = scanner.nextLine();
       
        
        boolean used;

        if(supplierTable.search(id)!=null){
            used = true;


        }
        else{
            used = false;
        }

        

        while(used){
            System.out.println("This ID has been used already");
            System.out.println("Do you want to continue(yes/no):");
            String ans = scanner.nextLine();
            while(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")){
                System.out.println("Enter only yes or no:");
                ans =scanner.nextLine();
                
            }
            if(ans.equalsIgnoreCase("no")){
                return;
            }
            if(ans.equalsIgnoreCase("yes")){
                System.out.println("Re enter the id:");
                id = scanner.nextInt();
                if(supplierTable.search(id)==null){
                    used = false;
                }

            }

        }
        Supplier newSupplier = new Supplier(id,name,company,phoneNumber,email,address);
        supplierTable.insert(id,newSupplier);
        suppliermanager.write(newSupplier);

        graph.addVertex(id+name);
        while(true){
            System.out.println("Enter a product(that supplier supplies):");
            productName = scanner.nextLine();
            newSupplier.addProductName(productName);
            graph.addEdge((id+name),productName);
            System.out.println("Do you want add more Item(yes/no)");
            String ans = scanner.nextLine();
            if(ans.equalsIgnoreCase("no")){
                break;
            }
            else if(!ans.equalsIgnoreCase("yes")&& !ans.equalsIgnoreCase("no")){
                System.out.println("Invalid Input");
                return;
            }

        }





        
    }
    public void updateSupplier(){
        int id;
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            while(true){
                try{
                    System.out.println("Enter the Supplier Id:");
                    id = Integer.parseInt(scanner.nextLine());

                    if(id<0){
                        throw new IllegalArgumentException("Id can be less  than 0");
                    }
                    break;
                }
                catch(NumberFormatException e){
                    System.out.println("Please enter number only.");

                }
                catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            }

            if(supplierTable.search(id)!=null){
                break;
            }
            else{
                System.out.println("Supplier id is not exit");
                System.out.println("Do you want to continue(yes/no):");
                String ans = scanner.nextLine();
                while(ans.equalsIgnoreCase("yes")&& ans.equalsIgnoreCase("no")){
                    System.out.println("Enter only yes or no:");
                    ans = scanner.nextLine();

                }
                if(ans.equalsIgnoreCase("no")){
                    return;
                }
                
            }
        
        }
        Supplier oldSupplier = supplierTable.search(id);
        Supplier changeSupplier = supplierTable.search(id);
        while(true){
            System.out.println("1.Id 2.Name 3.phone Number 4.Email 5.Address 6.Company");
            int ans;

            while(true){
                System.out.println("Please Enter choice :");
                ans = scanner.nextInt();
                
                if(ans<=0 || ans>6){
                    System.out.println("must enter 1 to 6");
                }
                else{
                    break;
                }

            }
            if(ans==1){
                int newId;
                while(true){
                    while(true){
                        System.out.println("Enter new Id:");
                        newId = scanner.nextInt();
                        if(newId<0){
                            System.out.println("Id must be greater than 0");
                        }
                        else{
                            break;
                        }
                    }

                
                   
    
                    if(supplierTable.search(newId)==null){
                        changeSupplier.setId(newId);
                        break;
                    }
                    else{
                        System.out.println("This new Id  was used alread");
                    }
                    

                }
                scanner.nextLine();
                String i;
                while(true){
                    System.out.println("Do you want continu(yes/no)");
                    i = scanner.nextLine();
                    if(!i.equalsIgnoreCase("yes")&& !i.equalsIgnoreCase("no")){
                        System.out.println("enter only yes or no");
                    }
                    else{
                        break;
                    }

                }
                if(i.equalsIgnoreCase("no")){
                    break;
                }
                
                

                
            }
            else if(ans==2){
                System.out.println("Enter new name:");
                String newName = scanner.nextLine();
                changeSupplier.setName(newName);

                String i;
                while(true){
                    System.out.println("Do you want continu(yes/no)");
                    i = scanner.nextLine();
                    if(!i.equalsIgnoreCase("yes")&& !i.equalsIgnoreCase("no")){
                        System.out.println("enter only yes or no");
                    }
                    else{
                        break;
                    }

                }
                if(i.equalsIgnoreCase("no")){
                    break;
                }


            }
            else if(ans==3){
                System.out.println("Enter new Phone Number:");
                String newNumber = scanner.nextLine();
                changeSupplier.setPhoneNumber(newNumber);

                String i;
                while(true){
                    System.out.println("Do you want continu(yes/no)");
                    i = scanner.nextLine();
                    if(!i.equalsIgnoreCase("yes")&& !i.equalsIgnoreCase("no")){
                        System.out.println("enter only yes or no");
                    }
                    else{
                        break;
                    }

                }
                if(i.equalsIgnoreCase("no")){
                    break;
                }


            
            }
            else if(ans == 4){
                System.out.println("Enter new Email:");
                String newEmail = scanner.nextLine();
                changeSupplier.setEmail(newEmail);

                String i;
                while(true){
                    System.out.println("Do you want continu(yes/no)");
                    i = scanner.nextLine();
                    if(!i.equalsIgnoreCase("yes")&& !i.equalsIgnoreCase("no")){
                        System.out.println("enter only yes or no");
                    }
                    else{
                        break;
                    }

                }
                if(i.equalsIgnoreCase("no")){
                    break;
                }

            }
            else if(ans==5){
                System.out.println("Enter new Address:");
                String newAddress = scanner.nextLine();
                changeSupplier.setAddress(newAddress);

                String i;
                while(true){
                    System.out.println("Do you want continu(yes/no)");
                    i = scanner.nextLine();
                    if(!i.equalsIgnoreCase("yes")&& !i.equalsIgnoreCase("no")){
                        System.out.println("enter only yes or no");
                    }
                    else{
                        break;
                    }

                }
                if(i.equalsIgnoreCase("no")){
                    break;
                }

            }
            else{
                System.out.println("Enter new Company");
                String newCompany = scanner.nextLine();
                changeSupplier.setCompany(newCompany);

                String i;
                while(true){
                    System.out.println("Do you want continu(yes/no)");
                    i = scanner.nextLine();
                    if(!i.equalsIgnoreCase("yes")&& !i.equalsIgnoreCase("no")){
                        System.out.println("enter only yes or no");
                    }
                    else{
                        break;
                    }

                }
                if(i.equalsIgnoreCase("no")){
                    break;
                }

            }

            
            
        }
        supplierTable.delete(id);
        supplierTable.insert(changeSupplier.getId(),changeSupplier);
        suppliermanager.write(changeSupplier);
        suppliermanager.updateFile(oldSupplier);

    }
    public void delteSupplier(){
        Scanner scanner = new Scanner(System.in);
        int deleteId;
        while(true){
            try{
                System.out.println("Enter the Customer Id:");
                deleteId = Integer.parseInt(scanner.nextLine());

                if(deleteId<0){
                    throw new IllegalArgumentException("Id can not be less  than 0");
                }
                if(supplierTable.search(deleteId)!=null){
                    
                    suppliermanager.updateFile(supplierTable.search(deleteId));
                    supplierTable.delete(deleteId);
                    graph.removeVertex(deleteId+supplierTable.search(deleteId).getName());
                    System.out.println("Customer deleted successfully.");
                    break;

                }
                else{
                    System.out.println("This Id is not exixt");
                    while(true){
                        
                        System.out.println("Do you want to continue(yes/no");
                        String ans = scanner.nextLine();
                        if(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")){
                            System.out.println("Enter only yes or no");
                        }
                        if(ans.equalsIgnoreCase("no")){
                            return;
                        }
                        else if(ans.equalsIgnoreCase("yes")){
                            break;

                        }
                       
                    }
                    
                    
                }

            }
            catch(NumberFormatException e){
                System.out.println("Error");
                System.out.println("Please Ente numbber only.");
                e.printStackTrace();

            }
            catch(IllegalArgumentException e){
                e.printStackTrace();
                while(true){
                    System.out.println("Do you want to continue(yes/no):");
                    String ans = scanner.nextLine();
                    if(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")){
                        System.out.println("Enter only yes or no");

                    }
                    if(ans.equalsIgnoreCase("no")){
                        return;
                    }
                    else if(ans.equalsIgnoreCase("yes")){
                        break;

                    }
                }

            }
          
            


        }
       

        
    }
    

        

    
}
