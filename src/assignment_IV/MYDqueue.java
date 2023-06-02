package assignment_IV;
import java.util.Scanner;


public class MYDqueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque deque = new Deque();
        int choice;

        do {
            System.out.println("\n1. Insert element at front");
            System.out.println("2. Insert element at rear");
            System.out.println("3. Delete element from front");
            System.out.println("4. Delete element from rear");
            System.out.println("5. Display deque");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");

             choice= scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int frontData = scanner.nextInt();
                    deque.insertFront(frontData);
                    break;

                case 2:
                    System.out.print("Enter element to insert: ");
                    int rearData = scanner.nextInt();
                    deque.insertRear(rearData);
                    break;

                case 3:
                    deque.deleteFront();
                    break;

                case 4:
                    deque.deleteRear();
                    break;

                case 5:
                    deque.display();
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
           
            }
        }while(choice!=0);
        scanner.close();
    }
}
class Deque {
    DoublyLinkedList list  = new DoublyLinkedList();
    void insertFront(int data) {
        list.insertAtBeginning(data);
    }

    void insertRear(int data) {
        list.insertAtEnd(data);
    }

    void deleteFront() {
        list.deleteFromBeginning();
    }

    void deleteRear() {
        list.deleteFromEnd();
    }

    void display() {
      list.display();
    }
}

