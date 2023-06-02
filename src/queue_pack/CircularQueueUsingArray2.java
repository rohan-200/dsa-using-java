package queue_pack;

import java.util.Scanner;


class MyCQueue { // Queue class
	int size, f, r;
	int q[];

	@SuppressWarnings("unchecked")
	MyCQueue(int size) {
		f = r = 0;
		this.size = size + 1; // for vacant space
		q = new int [this.size];
	}

	void ins(int n) throws QueueOverFlow {
		if ((r + 1) % size == f) // overflow
			throw new QueueOverFlow();

		r = (r + 1) % size;
		q[r] = n;
	}

	int del() throws QueueUnderFlow {
		if (r == f) // underflow
			throw new QueueUnderFlow();

		f = (f + 1) % size;
		return q[f];
	}

	void display() throws QueueUnderFlow {
		if (r == f) // underflow
			throw new QueueUnderFlow();

		int i = f;
		while (i != r) {
			i = (i + 1) % size;
			System.out.print(q[i] + " ");
		}
		System.out.println();
	}
}

public class CircularQueueUsingArray2 {
	static Scanner sc = new Scanner(System.in);

	static void menu(MyCQueue q) { // menu for each Queue
		int c;
		System.out.println("\n1. Insert\t2. Delete\t3. Display\t4. Exit");
		while (true) {
			System.out.print("\nEnter choice: ");
			c = sc.nextInt();
			switch (c) {
			default:
				System.out.println("Enter correctly");
				break;
			case 1:
				System.out.print("Enter no.: ");
				try {
					q.ins(sc.nextInt());
				} catch (QueueOverFlow e) {
					System.out.println("Queue Overflow");
				}
				break;
			case 2:
				try {
					System.out.println(q.del() + " is removed");
				} catch (QueueUnderFlow e) {
					System.out.println("Queue Underflow");
				}
				break;
			case 3:
				try {
					q.display();
				} catch (QueueUnderFlow e) {
					System.out.println("Queue Empty");
				}
				break;
			case 4:
				return;
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter Queue size: ");
		MyCQueue q = new MyCQueue(sc.nextInt());
		menu(q);
	}
}
