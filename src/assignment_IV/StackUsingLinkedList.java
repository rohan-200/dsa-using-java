package assignment_IV;


public class StackUsingLinkedList {
    SinglyLinkedList list = new SinglyLinkedList();
    public void push(int data) {
        list.insertEnd(data);
    }
    
    // Pop operation
    public void pop() {
        list.deleteEnd();
    }
    
    // Display the stack
    public void display() {
       list.display();
    }
    
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();
        stack.pop();
        stack.pop();
        stack.display();
    }
}

