package assignment_IV;

import java.util.Scanner;

public class SinglyLinkedList {
    public static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAt(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid position");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void deleteAt(int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Invalid position");
            return;
        }
        current.next = current.next.next;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int search(int data) {
        if (head == null) {
            return -1;
        }
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == data) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    public void insertAfter(int data, int after) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == after) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
        System.out.println("Element not found in the list");
    }
    
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("Element not found in the list");
    }
    
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    
    public void concatenate(SinglyLinkedList list) {
        if (head == null) {
            head = list.head;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list.head;
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, position, after;
        SinglyLinkedList sublist;
        do {
            System.out.println("1. Insert at front");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete from front");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from position");
            System.out.println("7. Display");
            System.out.println("8. Search");
            System.out.println("9. Insert after element");
            System.out.println("10. Delete element");
            System.out.println("11. Count nodes");
            System.out.println("12. Reverse");
            System.out.println("13. Concatenate");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = scanner.nextInt();
                    list.insertFront(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = scanner.nextInt();
                    list.insertEnd(data);
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    data = scanner.nextInt();
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    list.insertAt(data, position);
                    break;
                case 4:
                    list.deleteFront();
                    break;
                case 5:
                    list.deleteEnd();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    list.deleteAt(position);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.print("Enter data to search: ");
                    data = scanner.nextInt();
                    position = list.search(data);
                    if (position == -1) {
                        System.out.println("Element not found in the list");
                    } else {
                        System.out.println("Element found at position " + position);
                    }
                    break;
                case 9:
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    System.out.print("Enter element after which to insert: ");
                    after = scanner.nextInt();
                    list.insertAfter(data, after);
                    break;
                case 10:
                    System.out.print("Enter element to delete: ");
                    data = scanner.nextInt();
                    list.delete(data);
                    break;
                case 11:
                    System.out.println("Number of nodes: " + list.countNodes());
                    break;
                case 12:
                    list.reverse();
                    break;
                case 13:
                    System.out.println("Enter elements of second list (0 to end):");
                    sublist = new SinglyLinkedList();
                    do {
                        data = scanner.nextInt();
                        if (data != 0) {
                            sublist.insertEnd(data);
                        }
                    } while (data != 0);
                    list.concatenate(sublist);
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