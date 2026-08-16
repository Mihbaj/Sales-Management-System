package FileHandaling;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



import java.io.File;

import Employee.*;



public class UserFile {
        File file = new File("User.txt");
   
    public  void reader(){
        
        
        
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                User user = new User();
                user.setUserName(data[0]);
                user.setPassword(data[1]);
                user.setEmployeeId(Integer.parseInt(data[2]));
                UserManager.userTable.insert(user.getUserName(),user);


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
    public void write(User user){
        
        try(FileWriter writer = new FileWriter("User.txt",true)){
            writer.write(user.toString());
            writer.write(System.lineSeparator());

        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public void updateFile(User deleteUser){
        File temfile = new File("Temperary.txt");
        try(
            Scanner reader = new Scanner(file);
            FileWriter writer = new FileWriter("Temperary.txt",true)

        ){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                User user = new User();
                user.setUserName(data[0]);
                user.setPassword(data[1]);
                user.setEmployeeId(Integer.parseInt(data[2]));
                if(user.getUserName()==deleteUser.getUserName()){
                    continue;
                }
              
                writer.write(user.toString());
                writer.write(System.lineSeparator());


            }
            

        }
        catch(IOException e){
            System.out.print("Error");
            e.printStackTrace();
            return;
        }
        file.delete();
        temfile.renameTo(file);
        

    }
    
    
}
