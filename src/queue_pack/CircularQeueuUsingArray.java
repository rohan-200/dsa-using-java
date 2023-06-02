package queue_pack;

import java.util.Scanner;
//no space left vacent
class CircularQueue {
    private int front, rear, size;
    private int[] queueArray;
    
    public CircularQueue(int size) {
        this.size = size;
        front = -1;
        rear = -1;
        queueArray = new int[size];
    }
    
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queueArray[rear] = element;
            System.out.println("Element " + element + " enqueued");
        }
    }
    
    public int dequeue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        } else {
            element = queueArray[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            System.out.println("Element " + element + " dequeued");
            return element;
        }
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Elements in the queue:");
            int i = front;
            while (i != rear) {
                System.out.println(queueArray[i]);
                i = (i + 1) % size;
            }
            System.out.println(queueArray[rear]);
        }
    }
}

public class CircularQeueuUsingArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the circular queue: ");
        int size = input.nextInt();
        CircularQueue queue = new CircularQueue(size);
        while (true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to be enqueued: ");
                    int element = input.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
}

