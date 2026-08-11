package Customer;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashSet;
import HashTable.*;
import FileHandaling.CustomerFile;


public class CustomerManager {
    
    static public HashTable<Integer,Customer> customerTable = new HashTable<>();
    CustomerFile customermanager = new CustomerFile();

    boolean fileload=true;
    public CustomerManager(){
        if(fileload){
            customermanager.reader();
            fileload = false;
        }
    }
    

    public void createCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the following Details");
        System.out.println("ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Address(Do not use coma/,):");
        String address = scanner.nextLine();
        
        boolean used;

        if(customerTable.search(id)!=null){
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
                if(customerTable.search(id)==null){
                    used = false;
                }

            }

        }
        Customer newCustomer = new Customer(id,name,phoneNumber,email,address);
        customerTable.insert(id,newCustomer);
        customermanager.write(newCustomer);





        
    }
    public void updateCustomer(){
        int id;
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            while(true){
                try{
                    System.out.println("Enter the Customer Id:");
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

            if(customerTable.search(id)!=null){
                break;
            }
            else{
                System.out.println("Customer id is not exit");
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
        Customer oldCustomer = customerTable.search(id);
        Customer changeCustomer = customerTable.search(id);
        while(true){
            System.out.println("1.Id 2.Name 3.phone Number 4.Email 5.Address");
            int ans;

            while(true){
                System.out.println("Please Enter the number :");
                ans = scanner.nextInt();
                
                if(ans<=0 || ans>5){
                    System.out.println("must enter 1 to 5");
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

                
                   
    
                    if(customerTable.search(newId)==null){
                        changeCustomer.setId(newId);
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
                changeCustomer.setName(newName);

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
                changeCustomer.setPhoneNumber(newNumber);

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
                changeCustomer.setEmail(newEmail);

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
                System.out.println("Enter new Address:");
                String newAddress = scanner.nextLine();
                changeCustomer.setAddress(newAddress);

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
        customerTable.delete(id);
        customerTable.insert(changeCustomer.getId(),changeCustomer);
        customermanager.write(changeCustomer);
        customermanager.updateFile(oldCustomer);

    }
    public void delteCustomer(){
        Scanner scanner = new Scanner(System.in);
        int deleteId;
        while(true){
            try{
                System.out.println("Enter the Customer Id:");
                deleteId = Integer.parseInt(scanner.nextLine());

                if(deleteId<0){
                    throw new IllegalArgumentException("Id can not be less  than 0");
                }
                if(customerTable.search(deleteId)!=null){
                    
                    customermanager.updateFile(customerTable.search(deleteId));
                    customerTable.delete(deleteId);
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
