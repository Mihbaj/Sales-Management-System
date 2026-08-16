package HashTable;

public class SetADT<T> {
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public SetADT(){
        elements= (T[]) new Object[20];
        size = 0;
    }
    public boolean add(T element){
        if(contains(element)){
            return false;

        }
        if(size == elements.length){
            resize();
        }
        elements[size] = element;
        size++;
        return true;
    }
    public boolean contains(T element){
        for(int i = 0;i<size;i++){
            if(elements[i].equals(element)){
                return true;

            }
        }
        return false;
    }
    @SuppressWarnings("unckecked")
    private void resize(){
        T[] newArray = (T[]) new Object[elements.length*2];
        for(int i =0;i<size;i++){
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
    public boolean remove(T element){
        for(int i=0;i<size;i++){
            if(elements[i].equals(element)){
                for(int j = i; j<size-1;j++){
                    elements[j] = elements[j+1];
                }
                elements[size -1] = null;
                size --;

                return true;
            }
        }
        return false;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void display(){
        for(int i =0;i<size;i++){
            System.out.println(elements[i]);
        }
    }
    public T[] returnElement(){
        return elements;
    }
    
}
