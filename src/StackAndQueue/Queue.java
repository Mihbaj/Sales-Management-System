package StackAndQueue;

import Order.Order;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue(){
        front = null;
        rear = null;
        size = 0;
    }
    public Node<T> getFront(){
        return front;
    }
    
    public void insert(T data){
        Node<T> newNode = new Node<>(data);

        if(isEmpty()){
            front = rear= newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public T remove(){
        if(isEmpty()){
            System.out.println("Nothing is found");
            return null;
        }
        T removedData = front.data;
        front = front.next;

        if(front==null){
            rear = null;
        }
        size --;
        return removedData;
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return front.data;
    }

    public boolean isEmpty(){
        return front == null;

    }
    public int size(){
        return size;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Nothing is found.");
            return;
        }
        Node<T> current = front;
        while (current != null){
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.println("Null");

    }
   


    

    
}