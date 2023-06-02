package assignment_IV;

import java.util.Scanner;

public class DLList {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        int choice, data, position;

        do {
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at any position");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from any position");
            System.out.println("7. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    System.out.print("Enter position to insert at: ");
                    position = scanner.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    list.deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete from: ");
                    position = scanner.nextInt();
                    list.deleteFromPosition(position);
                    break;
                case 7:
                    list.display();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        scanner.close();
    }
}

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode previous;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public void insertAtBeginning(int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (position == 1) {
            insertAtBeginning(data);
        } else {
            DoublyLinkedListNode current = head;
            int currentPosition = 1;

            while (current != null && currentPosition < position - 1) {
                current = current.next;
                currentPosition++;
            }

            if (current == null) {
                System.out.println("Invalid position");
            } else {
                newNode.next = current.next;
                newNode.previous = current;
                current.next.previous = newNode;
                current.next = newNode;
            }
        }
    }
    
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
    }
    
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
    }
    
    public void deleteFromPosition(int position) {
        if (position == 1) {
            deleteFromBeginning();
        } else {
            DoublyLinkedListNode current = head;
            int currentPosition = 1;
    
            while (current != null && currentPosition < position) {
                current = current.next;
                currentPosition++;
            }
    
            if (current == null) {
                System.out.println("Invalid position");
            } else {
                current.previous.next = current.next;
    
                if (current.next != null) {
                    current.next.previous = current.previous;
                }
            }
        }
    }
    
    public void display() {
        DoublyLinkedListNode current = head;
    
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}