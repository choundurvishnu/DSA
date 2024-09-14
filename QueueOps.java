package A1;

import java.util.Scanner;

public class QueueOps {
	
	private int[] queueArray;
    private int front, rear, size, capacity;

    QueueOps(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = value;
        size++;
        System.out.println("Enqueued " + value);
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; 
            }
        int value = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; 
        }
        return queueArray[front];
    }

    
    boolean isEmpty() {
        return size == 0;
    }

    
    boolean isFull() {
        return size == capacity;
    }


    void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue elements:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.println(queueArray[index]);
        }
    }
//}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the queue: ");
    int size = scanner.nextInt();
    QueueOps queue = new QueueOps(size);

    while (true) {
        System.out.println("Choose an operation:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek");
        System.out.println("4. Print Queue");
        System.out.println("5. Exit");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the value to enqueue: ");
                int enqueueValue = scanner.nextInt();
                queue.enqueue(enqueueValue);
                break;
            case 2:
                int dequeuedValue = queue.dequeue();
                if (dequeuedValue != -1) {
                    System.out.println("Dequeued " + dequeuedValue);
                }
                break;
            case 3:
                int peekValue = queue.peek();
                if (peekValue != -1) {
                    System.out.println("Front element is " + peekValue);
                }
                break;
            case 4:
                queue.printQueue();
                break;
            case 5:
                System.out.println("Exiting...");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}


}
