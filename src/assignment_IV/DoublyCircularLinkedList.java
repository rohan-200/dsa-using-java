package assignment_IV;

import java.io.Console;
import java.util.Scanner;

public class DoublyCircularLinkedList {
    private static class Node {
        int data;
        Node previous;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.previous = tail;
            tail.next = head;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            head.previous = tail;
            tail.next = head;
        }
        size++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.previous = tail;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            head.previous = tail;
            tail.next = head;
        }
        size++;
    }

    public void insertAtPosition(int data, int position) {
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        if (position == size + 1) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int currentPosition = 1;
        while (currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }
        newNode.next = current.next;
        current.next.previous = newNode;
        current.next = newNode;
        newNode.previous = current;
        size++;
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head == tail) {
            head = null;
            tail = null;
            size--;
        } else {
            head = head.next;
            head.previous = tail;
            tail.next = head;
            size--;
        }
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head == tail) {
            head = null;
            tail = null;
            size--;
        } else {
            tail = tail.previous;
            tail.next = head;
            head.previous = tail;
            size--;
        }
    }

    public void deleteFromPosition(int position) {
        try {
            if (position == 1) {
                deleteFromBeginning();
                return;
            }
    
            if (position == size) {
                deleteFromEnd();
                return;
            }
    
            Node current = head;
            int currentPosition = 1;
            while (currentPosition < position) {
                current = current.next;
                currentPosition++;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        int choice;
        do {
            System.out.println("1. Insert an element at the beginning of the list");
            System.out.println("2. Insert an element at the end of the list");
            System.out.println("3. Insert an element at a specific position in the list");
            System.out.println("4. Delete an element from the beginning of the list");
            System.out.println("5. Delete an element from the end of the list");
            System.out.println("6. Delete an element from a specific position in the list");
            System.out.println("7. Display the list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to be inserted: ");
                    int data1 = scanner.nextInt();
                    list.insertAtBeginning(data1);
                    break;
                case 2:
                    System.out.print("Enter the element to be inserted: ");
                    int data2 = scanner.nextInt();
                    list.insertAtEnd(data2);
                    break;
                case 3:
                    System.out.print("Enter the element to be inserted: ");
                    int data3 = scanner.nextInt();
                    System.out.print("Enter the position at which to insert the element: ");
                    int position3 = scanner.nextInt();
                    list.insertAtPosition(data3, position3);
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    list.deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter the position from which to delete the element: ");
                    int position6 = scanner.nextInt();
                    list.deleteFromPosition(position6);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 8);
        scanner.close();
    }
}    
