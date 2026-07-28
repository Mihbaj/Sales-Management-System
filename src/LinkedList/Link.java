package LinkedList;
import java.util.LinkedList;

public class Link {
    public static void main(String[] args){
        LinkedList<Student> list = new LinkedList<>();
        list.add(new Student(567,"Mihbaj"));
        list.add(new Student(345,"Ilham"));

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
    public void displayLink(){

    }
    


    
}
