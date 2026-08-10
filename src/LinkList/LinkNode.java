package LinkList;

public class LinkNode<T> {
    private  T data;
    private LinkNode<T> next;
    private LinkNode<T> previous;

    public LinkNode(T data){
        this.data = data;
        next = null;
        previous = null;
    }

    public T getData(){
        return data;
    }
    public  LinkNode<T> getNext(){
        return next;
    }
    public void setNext(LinkNode<T> node){
        next = node;
    }
    public void setPrevious(LinkNode<T> node){
        previous = node;
    }
    public LinkNode<T> getPrevious(){
        return previous;
    }
   
    
}
