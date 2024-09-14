package A1;

import java.util.Scanner;

public class Stackops {
	
	
	static class Stack {
        private int[] stackArray;
        private int top;
        private int capacity;

       Stack(int size) {
            capacity = size;
            stackArray = new int[capacity];
            top = -1;
        }
        
        
        void push(int value) {
            if (isFull()) {
                System.out.println("Stack is full. Cannot push " + value);
                return;
            }
            stackArray[++top] = value;
            System.out.println("Pushed " + value);
        }

        
        int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot pop.");
                return -1; 
            }
            return stackArray[top--];
        }
        
        
        int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot peek.");
                return -1; 
            }
            return stackArray[top];
        }
        
        
        
        boolean isEmpty() {
            return top == -1;
        }

        boolean isFull() {
            return top == capacity - 1;
        }

        void printStack() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return;
            }
            System.out.println("Stack elements:");
            for (int i = 0; i <= top; i++) {
                System.out.println(stackArray[i]);
            }
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Print Stack");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to push: ");
                    int pushValue = scanner.nextInt();
                    stack.push(pushValue);
                    break;
                case 2:
                    int poppedValue = stack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped " + poppedValue);
                    }
                    break;
                case 3:
                    int peekValue = stack.peek();
                    if (peekValue != -1) {
                        System.out.println("Top element is " + peekValue);
                    }
                    break;
                case 4:
                    stack.printStack();
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
