package queue_pack;

import java.util.*;

class Queue {
    private List<Integer> queueList = new ArrayList<Integer>();
    private int maxSize;
    
    public Queue(int size) {
        this.maxSize = size;
    }
    
    public void enqueue(int element) throws Exception {
        if (queueList.size() == maxSize) {
            throw new Exception("Queue Overflow");
        } else {
            queueList.add(element);
        }
    }
    
    public int dequeue() throws Exception {
        if (queueList.size() == 0) {
            throw new Exception("Queue Underflow");
        } else {
            int element = queueList.get(0);
            queueList.remove(0);
            return element;
        }
    }
    
    public boolean isSimilar(Queue queue2) {
        List<Integer> list1 = new ArrayList<Integer>(queueList);
        List<Integer> list2 = new ArrayList<Integer>(queue2.queueList);
        
        Set<Integer> set1 = new HashSet<Integer>(list1);
        Set<Integer> set2 = new HashSet<Integer>(list2);
        
        return set1.equals(set2);
    }
}

public class MyQueue {
    public static void main(String[] args) {
        Queue queue1 = new Queue(5);
        Queue queue2 = new Queue(5);
        
        try {
            queue1.enqueue(1);
            queue1.enqueue(2);
            queue1.enqueue(3);
            queue1.enqueue(4);
            queue1.enqueue(5);
            
            queue2.enqueue(5);
            queue2.enqueue(4);
            queue2.enqueue(3);
            queue2.enqueue(2);
            queue2.enqueue(1);
            
            System.out.println(queue1.isSimilar(queue2));
            queue2.dequeue();//remove 1 element from queue
            System.out.println("checking after removing one or more element is they are same or not\n"+queue1.isSimilar(queue2));



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
