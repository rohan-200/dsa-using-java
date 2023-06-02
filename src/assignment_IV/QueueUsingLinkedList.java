package assignment_IV;

import javax.swing.SingleSelectionModel;

public class QueueUsingLinkedList {
    

    SinglyLinkedList list = new SinglyLinkedList();

    // Enqueue operation
    public void enqueue(int data) {
        list.insertEnd(data);
    }
    
    // Dequeue operation
    public void dequeue() {
       list.deleteFront();
    }
    
    // Display the queue
    public void display() {
       list.display();
    }
    
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();
        queue.dequeue();
        queue.dequeue();
        queue.display();
    }
}
