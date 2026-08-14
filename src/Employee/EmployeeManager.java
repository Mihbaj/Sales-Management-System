package Employee;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.util.HashSet;
import SortingAlgorithams.*;


import LinkList.*;


public class EmployeeManager {
    static HashSet<Integer> id = new HashSet<>();
    static HashSet<String> email = new HashSet<>();
    static LinkList<Employee> employeeList = new LinkList<>();
    static File file = new File("Employees.txt");
    static File tem = new File("Temperary.txt");

    static boolean fileload = true;

    public EmployeeManager(){
        if (fileload){
            employeeReader();
            fileload = false;
        }
        

    }
    static Scanner scanner = new Scanner(System.in);

    public void addEmployee(){
        
        System.out.println("Name:");
        String name =scanner.nextLine();
        System.out.println("ID:");
        int emid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Role");
        String role = scanner.nextLine();
        System.out.println("Phone Number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Email:");
        String emEmail = scanner.nextLine();
        System.out.println("Address:");
        String address = scanner.nextLine();

        
        boolean available;

        
        // when i give used id and email to a employee, i could change only Id 
       
        boolean isIdAvailable = id.contains(emid);
        boolean isEmailAvailable= email.contains(emEmail);
        
        while(isIdAvailable||isEmailAvailable){ 
            while(isIdAvailable){
                System.out.println("This ID has been assigned already!");
                System.out.println("1.Re Enter the Id");
                System.out.println("2.Exit");
                int i = scanner.nextInt();
                if(i==1){
                    System.out.println("ID:");
                    emid = scanner.nextInt();
                    scanner.nextLine();
                    isIdAvailable = id.contains(emid);
                    
                }
                else{
                    return;
                }
                
                    
                    
                    

            }
            while(isEmailAvailable){
                System.out.println("This Email has been assigned already!");
                System.out.println("1.Re Enter Email");
                System.out.println("Exit");
                int i = scanner.nextInt();
                if(i==1){
                    System.out.println("Ender the Email:");
                    scanner.nextLine();
                    emEmail = scanner.nextLine();
                    isEmailAvailable = email.contains(emEmail);
                    
                }
                else{
                    return;
                }
            }
        }
                    
        Employee employee = new Employee(emid,name,role,phoneNumber,emEmail,address);
        
        try(FileWriter writer = new FileWriter("Employees.txt",true)){
            writer.write(employee.toString());
            writer.write(System.lineSeparator());
            id.add(employee.getId());
            email.add(employee.getEmail());
            employeeList.add(employee);
        }
        catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();


        }
        
    }
    public static void employeeReader(){
        
        
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Employee employee = new Employee(Integer.parseInt(data[1]),data[0],data[2],data[3],data[4],data[5]);
                employee.setUserName(data[6]);

                id.add(employee.getId());
                email.add(employee.getEmail());
                employeeList.add(employee);

            }

        }
        catch(FileNotFoundException e){
            try{
                if(file.createNewFile()){
                    System.out.println("File is created;"+file.getName());
                }
            
            }
            catch(IOException n){
                System.out.println("Error");
                n.printStackTrace();

            }
        }
    }
    public void deleteEmployee(){
        System.out.println("Enter the Id:");
        int deleteId = scanner.nextInt();

        boolean isAvailableId = id.contains(deleteId);
        while(!isAvailableId){
            System.out.println("ID is not Founted!");
            System.out.println("1.RE Enter the Id:");
            System.out.println("2.EXit");
            System.out.println("Enter the Number:");
            int i = scanner.nextInt();
            if(i==1){
                System.out.println("Re Enter the Id:");
                deleteId = scanner.nextInt();
                isAvailableId=id.contains(deleteId);
            

            }
            else{
                return;
            }



        }
        LinkNode<Employee> current = employeeList.getFirst();
        
        for(int i=1;i<=employeeList.length();i++){
            
            if(current.getData().getId()==deleteId){
                employeeList.delete(current.getData());
                id.remove(deleteId);
                rewriteFile(deleteId);
                System.out.println("Delted Succesfully.");
                return;

            }
            current = current.getNext();
        }
        

       
        /*  
        boolean remove = false;
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while(employeeIterator.hasNext()){
            Employee employee = employeeIterator.next();
            if(employee.getId() == deleteId){
                employeeIterator.remove();
                remove = true;
                break;
            }
        }
        if(remove){
             id.remove(deleteId);

            rewriteFile(deleteId);
            System.out.println("Delted Succesfully.");

        } */
       


            
    

    }
    public void updateEmployee(){
        System.out.println("Enter the ID:");
        int updateId = scanner.nextInt();
        boolean  isAvailableId = id.contains(updateId);

        while(!isAvailableId){
            System.out.println(updateId+" is not founded!");
            System.out.println("1.Re Enter ID");
            System.out.println("2.Exit");
            System.out.println("Ender the NUmber:");

            int i = scanner.nextInt();
            if(i == 1){
                System.out.println("Enter the Id:");
                updateId = scanner.nextInt();
                isAvailableId = id.contains(updateId);
            }
            else{
                System.out.println("DO you Want to Exit(yes/no):");
                scanner.nextLine();
                String ans = scanner.nextLine();
                if(ans.equalsIgnoreCase("yes")){
                    return;
                }
                else{
                    System.out.println("Re Enter ID:");
                    updateId = scanner.nextInt();
                    isAvailableId=id.contains(updateId);

                }
            }
        }
        LinkNode<Employee> current = employeeList.getFirst();

        for(int i=1;i<=employeeList.length();i++){
          
            if(current.getData().getId()==updateId){
                Employee updateEmployee = current.getData();
                updateInput(updateEmployee);
                rewriteFile(updateId);
                fileWrite(updateEmployee);
                System.out.println("Uptated succesfully");
                return;

            }
            current = current.getNext();
        }

/* 
        Iterator<Employee> employeeIterator = employeeList.iterator();
        
        while(employeeIterator.hasNext()){
            Employee employee = employeeIterator.next();
            
            if(employee.getId()==updateId){
               
                updateInput(employee);
                rewriteFile(updateId);s
                fileWrite(file,employee);
                
                return;
 
            }
        }
       
*/    
   


    }

    public static void rewriteFile(int id){
        try{
            Scanner reader = new Scanner(file);
            FileWriter writer = new FileWriter(tem);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                Employee em =createEmployeeFromLine(line);

                if(em.getId()!=id){
                    writer.write(line);
                    writer.write(System.lineSeparator());
                }
            }
            reader.close();
            writer.close();
            file.delete();
            tem.renameTo(file);
        }
        catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();
        }



    }
    public static Employee createEmployeeFromLine(String line){
       String[] data = line.split(",");
       Employee employee = new Employee(Integer.parseInt(data[1]),data[0],data[2],data[3],data[4],data[5]);
       return employee;
    }
// UpdateInput method
    public void updateInput(Employee employee){
        
        employee.displayEmployee();
        
        boolean whileControlar = true;
        

        

        while(whileControlar){
            
            System.out.println("1.Employee ID");
            System.out.println("2.Name:");
            System.out.println("3.Role");
            System.out.println("4.Phone Number");
            System.out.println("5.Email");
            System.out.println("6.Address");
            System.out.println("7.Exit");
            System.out.println("Choose the Number you want to change:");

            int i = scanner.nextInt();
            scanner.nextLine();
            if(i==1){
               
                System.out.println("Ender the new Id:");
                int newId = scanner.nextInt();
                scanner.nextLine();
               
                boolean isAvailableId=id.contains(newId);
                while(isAvailableId){
                    System.out.println("This Id is used already!");
                    System.out.println("1.Re Ender the Id");
                    System.out.println("2.Don't Change");
                    System.out.println("Entet the Number:");
                    i=scanner.nextInt();
                    scanner.nextLine();
                    if(i==1){
                        System.out.println("Enter the new Id:");
                        newId = scanner.nextInt();
                        scanner.nextLine();
                        isAvailableId =id.contains(newId);

                        
                    }
                    else{
                        whileControlar = chooseReRun();
                    }
                    
                }
                
                if(!isAvailableId){
                    id.remove(employee.getId());
                    employee.setId(newId);
                    id.add(newId);   

                }
                
                whileControlar = chooseReRun();

                

            }
            else if(i==2){
                
                System.out.println("Enter the new name:");
                
                String newName = scanner.nextLine();
                employee.setName(newName);
                whileControlar = chooseReRun();


            }
            else if(i==3){
              
                System.out.println("Enter the new role:");
                String newRole = scanner.nextLine();
                employee.setRole(newRole);
                whileControlar = chooseReRun();
            }

            else if(i==4){
              
                System.out.println("Enter the PhoneNumber:");
                String newPhoneNumber = scanner.nextLine();
                employee.setPhoneNumber(newPhoneNumber);
                whileControlar = chooseReRun();

            }
            else if(i==5){
              
            
                System.out.println("Enter the new Email:");
                String newEmail = scanner.nextLine();
                boolean isAvailableEmail = email.contains(newEmail);

                while(isAvailableEmail){
                    System.out.println("This Email is used already!");
                    System.out.println("1.RE Enter new Email");
                    System.out.println("2.Don't Change");
                    System.out.println("Enter the number:");
                    int ans = scanner.nextInt();
                    scanner.nextLine();
                   

                    if(ans==1){
                        System.out.println("Re Enter the new Eamil:");
                        newEmail = scanner.nextLine();
                        isAvailableEmail = email.contains(newEmail);

                    }
                    else{
                        whileControlar = chooseReRun();
                    }
                }
                
                
                if(!isAvailableEmail){
                    employee.setEmail(newEmail);
                    email.remove(employee.getEmail());
                    email.add(newEmail);
                }
                whileControlar = chooseReRun();

            
            }
            else if(i==6){
                
                System.out.println("Enter the new Address:");
               
                String newAddress = scanner.nextLine();
                employee.setAddress(newAddress);
                whileControlar = chooseReRun();
            }
            else{
                return;
            }

        }
       
        
        
    }
    // this method is used in updateInput methos to rerun the program
    public static boolean chooseReRun(){
        
        System.out.println("Do you want to continue update(yes/no):");
        
        String continueAnswer = scanner.nextLine();
        if(continueAnswer.equalsIgnoreCase("no")){
            return false;
        }
        else{
            
            return true;
        }
        
        


    }
    public void fileWrite(Employee employee){
        try(FileWriter writer = new FileWriter(file,true)){
            writer.write(employee.toString());
            writer.write(System.lineSeparator());
        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    /* public void employeeIterator(int id){
        Iterator<Employee> pointer = employeeList.iterator();
        while(pointer.hasNext()){
            Employee employee = pointer.next();
            String line = employee.toString();
        }
    } */

  /*   public boolean searchEmployeeFromList(int id){
        LinkNode<Employee> current = employeeList.getFirst();
        for(int i=1;i<=employeeList.length();i++){
           
            if(current.getData().getId()==id){
                return true;
            }
            current = current.getNext();
        }
        return false;
        
        
    }*/
    public Employee search(int id){
        LinkNode<Employee> current = employeeList.getFirst();
        while(current!=null){
            if(current.getData().getId()==id){
                return current.getData();
                

            }
            current = current.getNext();
        }
        return null;
    }
    public void search(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter the employee id:");
            int searchId = sc.nextInt();
            sc.nextLine();
            LinkNode<Employee> current = employeeList.getFirst();
            while(current!=null){
                if(current.getData().getId() == searchId){
                    current.getData().displayEmployee();
                    return;
                }
                current = current.getNext();
            }
            System.out.println("This id is not Exit");
            System.out.println("Do you want to continue(yes/no)");
            String ans = sc.nextLine();
            if(ans.equalsIgnoreCase("no") || (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"))){
                return;

            }
                
        }
    }
    public void displayAll(){
        Sorting<Integer> sorting = new Sorting<>();
        Integer[] array = new Integer[employeeList.length()];
        int index=0;
        LinkNode<Employee> current = employeeList.getFirst();
        if(current == null){
            System.out.println("There are not employees");
            return;

        }
        while(current!=null){
            array[index] = current.getData().getId();
            index++;
            current = current.getNext();
        }
        sorting.selectionSort(array);
        for(int i =0;i<array.length;i++){
            Employee employee = search(array[i]);
            employee.displayEmployee();


        }

    }

    

       
}

