package StackAndQueue;
class StackX {
    private int maxSize;
    private double[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new double[maxSize];
        top = -1;
    }

    public void push(double j) {
        if (top == maxSize - 1)
            System.out.println("Stack is full");
        else
            stackArray[++top] = j;
    }

    public double pop() {
        if (top == -1)
            return -99;
        else
            return stackArray[top--];
    }

    public double peek() {
        if (top == -1)
            return -99;
        else
            return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

public class Stack {
    public static void main(String[] args) {

        StackX theStack = new StackX(10);

        theStack.push(30);
        theStack.push(80);
        theStack.push(100);
        theStack.push(25);

        System.out.println("Top Element: " + theStack.peek());

        while (!theStack.isEmpty()) {
            double val = theStack.pop();
            System.out.println(val);
        }
    }
}