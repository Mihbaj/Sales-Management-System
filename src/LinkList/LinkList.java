package LinkList;

public class LinkList<T> {

    private LinkNode<T> first;
    private int length = 0;

    public LinkList(){
        first=null;

    }
    public boolean isEmplyt(){
        return (first==null);
    }
    public LinkNode<T> getFirst(){
        return first;
    }

    public boolean find(T t){
        
        LinkNode<T> current = first;
        while(current != null){
            if(current.getData().equals(t)){
                return true;

            }
            current = current.getNext();

        }
        return false;


    }
    
    public LinkNode<T> returnNode(T t){
        LinkNode<T> current = first;
        while(current!=null){
            if(current.getData().equals(t)){
                return current;
            }
            current = current.getNext();
        }
        return null;
    } 

    public void add(T t){
        LinkNode<T> newNode = new LinkNode<>(t);
        newNode.setNext(first);
        if(first != null){
            first.setPrevious(newNode);

        }
       
        first = newNode;
        length++;


    }
    public void delete(T t){
        LinkNode<T> deleteNode = returnNode(t);
        if(deleteNode == null){
            System.out.println("This List has no element");
            return;
        }
        
        if(deleteNode==first){
               
                
            first = first.getNext();
                
            length--;
            return;

        }
            
               
        LinkNode<T> preNode = deleteNode.getPrevious();
        preNode.setNext(deleteNode.getNext());
        if(deleteNode.getNext()!=null){
            deleteNode.getNext().setPrevious(preNode);

        }
                
               
        length--;

    
        

    }
    public int length(){
        return length;
    }
    
}
