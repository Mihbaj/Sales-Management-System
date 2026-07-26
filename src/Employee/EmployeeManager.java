package Employee;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.util.HashSet;


public class EmployeeManager {
    static HashSet<Integer> id = new HashSet<>();
    static HashSet<String> email = new HashSet<>();

    public EmployeeManager(){
        employeeReader();


    }
     Scanner scanner = new Scanner(System.in);
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

        boolean isIdAvailable = id.contains(emid);
        boolean isEmailAvailable = email.contains(emEmail);

        
        
        while(isIdAvailable){
            System.out.println("This ID has been assigned already!");
            System.out.println("1.Re Enter Id");
            System.out.println("2.Exit");
            int i = scanner.nextInt();
            if(i == 1){
                System.out.println("ID:");
                emid = scanner.nextInt();
                isIdAvailable = id.contains(emid);

            }
            else{
                return;
            }

        }
    
        
        while(isEmailAvailable){

            System.out.println("This  Email has been assigned already!");
            System.out.println("1.Re Enter Email");
            System.out.println("2.Exit");
            int i = scanner.nextInt();
            if(i==1){
                System.out.println("Email:");
                scanner.nextLine();
                emEmail = scanner.nextLine();
                isEmailAvailable = email.contains(emEmail);

            }
            else{
                return;
            }

        } 
        
        Employee employee = new Employee(emid,name,role,phoneNumber,emEmail,address);
        
        try(FileWriter writer = new FileWriter("Employees.txt",true)){
            writer.write(employee.toString());
            writer.write(System.lineSeparator());
            id.add(employee.getId());
            email.add(employee.getEmail());
        }
        catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();


        }
        
    }
    public static void employeeReader(){
        File file = new File("Employees.txt");
        
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                Employee employee = new Employee(Integer.parseInt(data[1]),data[0],data[2],data[3],data[4],data[5]);

                id.add(employee.getId());
                email.add(employee.getEmail());

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

        if(id.contains(deleteId)){
            id.remove(deleteId);
        }
        else{
            System.out.println(deleteId+" is not founded");
        }

    }
    public void updateEmployee(){

    }

       
}

