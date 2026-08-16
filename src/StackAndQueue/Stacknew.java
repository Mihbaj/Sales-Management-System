package StackAndQueue;
import LinkList.*;

public class Stacknew {
    private LinkList<String> recentActivites = new LinkList<>();
    private int totalActivites;
    private String lastActivite;

    public void addActivite(String activite){
        recentActivites.add(activite);
        totalActivites++;
        lastActivite=activite;
    }
    public void deleteActivite(){
        recentActivites.delete(lastActivite);
        LinkNode<String> first = recentActivites.getFirst();
        lastActivite = first.getData();
        totalActivites--;
    }
    public void peek(){
        if(lastActivite==null){
            System.out.println("Not Found");
        }
        else{
            System.out.println(lastActivite);
        }
            
        
    }
    public void deleteAll(){
        LinkNode<String> first = recentActivites.getFirst();
        if(first!=null){
            first =null;
            totalActivites = 0;
            lastActivite = null;
            System.out.println("Delted Succesfully");
        }
        else{
            System.out.println("There are no recent activites");
        }


    }
}
