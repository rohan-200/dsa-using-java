package queue_pack;

import java.util.Scanner;

/*
 * 3. Write a menu driven program to implement a dequeue using array.
 */

class MyDQueue { // Queue class
	int size, l, r;
	int q[];

	@SuppressWarnings("unchecked")
	MyDQueue(int size) {
		l = r = 0;
		this.size = size;
		q = new int [size];
	}

	void insR(int n) throws QueueOverFlow {
		if (r - l == size) // overflow
		{
			l = l % size;
			r = l + size;
			throw new QueueOverFlow();
		}

		q[r % size] = n;
		r++;
	}

	void insL(int n) throws QueueOverFlow {
		if (r - l == size) // overflow
		{
			l = l % size;
			r = l + size;
			throw new QueueOverFlow();
		}

		if (l == 0) {
			l += size;
			r += size;
		}

		l--;
		q[l % size] = n;
	}

	int delL() throws QueueUnderFlow {
		if (r == l) // underflow
		{
			l = l % size;
			r = l;
			throw new QueueUnderFlow();
		}

		int t = q[l % size];
		l++;

		return t;
	}

	int delR() throws QueueUnderFlow {
		if (r == l) // underflow
		{
			l = l % size;
			r = l;
			throw new QueueUnderFlow();
		}

		r--;

		return q[r % size];
	}

	void display() throws QueueUnderFlow {
		if (r == l) // underflow
			throw new QueueUnderFlow();

		for (int i = l; i < r; i++)
			System.out.print(q[i % size] + " ");
		System.out.println();
	}
}

public class Deque {
	static Scanner sc = new Scanner(System.in);

	static void menu(MyDQueue q) { // menu for each Queue
		int c;
		System.out.print("\n1. Insert Left\t2. Insert Right\t3. Delete Left");
		System.out.println("\t4. Delete Right\t5. Display\t6. Exit");
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
					q.insL(sc.nextInt());
				} catch (QueueOverFlow e) {
					System.out.println("Queue Overflow");
				}
				break;
			case 2:
				System.out.print("Enter no.: ");
				try {
					q.insR(sc.nextInt());
				} catch (QueueOverFlow e) {
					System.out.println("Queue Overflow");
				}
				break;
			case 3:
				try {
					System.out.println(q.delL() + " is removed");
				} catch (QueueUnderFlow e) {
					System.out.println("Queue Underflow");
				}
				break;
			case 4:
				try {
					System.out.println(q.delR() + " is removed");
				} catch (QueueUnderFlow e) {
					System.out.println("Queue Underflow");
				}
				break;
			case 5:
				try {
					q.display();
				} catch (QueueUnderFlow e) {
					System.out.println("Queue Empty");
				}
				break;
			case 6:
				return;
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter Queue size: ");
		MyDQueue q = new MyDQueue(sc.nextInt());
		menu(q);
	}
}
