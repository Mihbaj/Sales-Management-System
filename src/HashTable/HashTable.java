package HashTable;



public class HashTable<K,V> {
    private HashNode<K,V>[] table;
    private int elementCount;

    private static final int INITIAL_SIZE = 100;
    private static final double LOAD_FACTOR = 0.75;

    
    @SuppressWarnings("unckecked")
    public HashTable(){
        table = (HashNode<K,V>[] ) new HashNode[INITIAL_SIZE];
        elementCount = 0;
    }
    private int hashFunction(K key){

        if(key==null){
            throw new IllegalArgumentException("Key cannot be null");
        }
        return Math.floorMod(key.hashCode(),table.length);
    }
    public void insert(K key, V value){
        if (key== null || value == null){
            System.out.println("Object can't be null");
            return;
        }
        if (search(key) != null){
            
            return;
        }
        double currentLoadFactor = (double) elementCount/table.length;
        
        if (currentLoadFactor >= LOAD_FACTOR){
            resize();

        }
        int index = hashFunction(key);

        HashNode<K,V> newNode = new HashNode<>(key,value);

        newNode.next = table[index];
        table[index] = newNode;
        elementCount++;

       
    }

    public V search(K key){
        int index = hashFunction(key);

        HashNode<K,V> current = table[index];

        while (current != null){
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public boolean delete(K key){

        int index = hashFunction(key);

        HashNode<K,V> current = table[index];
        HashNode<K,V> previous = null;

        while (current != null){
            if (current.key.equals(key)){
                if (previous == null){
                    table[index] = current.next;
                }
                else{
                    previous.next = current.next;
                }
                elementCount--;
                System.out.println("Product deleted successfully.");
                return true;
            }
            previous = current;
            current = current.next;


        }
        System.out.println("Product not found.");
        return false;
    }

   

   

    public void displayAll(){
        if (elementCount == 0){
            System.out.println("No products available.");
            return;
        }
        for (int i = 0; i < table.length; i++){
            HashNode<K,V> current = table[i];
            while (current != null){
                System.out.println(current.value);
                current = current.next;
            }
        }
        
        

    }
    public void displayHashTable() {
        for (int i = 0; i < table.length; i++){
            System.out.print("Index " + i + " -> ");

            HashNode<K,V> current = table[i];

            while (current != null){
                System.out.print("[" + current.key+ " - " + current.value+ "] -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public int  size(){
        return elementCount;

    }
    public boolean isEmpty(){
        return elementCount == 0;

    }
    @SuppressWarnings("unchecked")

    private void resize(){
        HashNode<K,V>[] oldTable = table;
        table = (HashNode<K,V>[]) new HashNode[oldTable.length * 2];
        elementCount = 0;

        for (HashNode<K,V> oldBucket : oldTable){
            HashNode<K,V> current = oldBucket;

            while (current != null){
                HashNode<K,V> nextNode = current.next;

                int newIndex =hashFunction(current.key);

                current.next = table[newIndex];
                table[newIndex] = current;

                elementCount++;

                current = nextNode;
            }

        }
       

    }
}
