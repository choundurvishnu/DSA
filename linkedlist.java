package A1;

import java.util.Scanner;

public class linkedlist 
{
	static class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data = data;
			this.next = null;
			
		}
	}
	
	static class LinkedList
	{
		
		Node head;
		
		void createList(int[] values) {
			if(values.length ==0)
			{
				head = null;
				return;
				
			}
			
			head = new Node(values[0]);
			Node current = head;
			
			for(int i=1;i<values.length; i++)
			{
				current.next = new Node(values[i]);
				current = current.next;
			}
		}
		
		
		void insertElement(int index, int value) {
            Node newNode = new Node(value);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
                return;
            }

            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current == null) {
                    System.out.println("Index out of bounds.");
                    return;
                }
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
		


        

        void deleteElement(int index) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (index == 0) {
                head = head.next;
                return;
            }

            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current == null || current.next == null) {
                    System.out.println("Index out of bounds.");
                    return;
                }
                current = current.next;
            }

            current.next = current.next.next;
        }

		
        void traverseList() {
            Node current = head;
            int index = 0;
            while (current != null) {
                System.out.println("Element at index " + index + ": " + current.data);
                current = current.next;
                index++;
            }
        }
		
		
	}

	public static void main(String[] args) 
	{
		
		Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        while (true) {
            System.out.println("Choose an operation Linked List:");
            System.out.println("1. Create List");
            System.out.println("2. Insert Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Traverse List");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of elements: ");
                    int n = scanner.nextInt();
                    int[] values = new int[n];
                    System.out.println("Enter the elements:");
                    for (int i = 0; i < n; i++) {
                        values[i] = scanner.nextInt();
                    }
                    linkedList.createList(values);
                    break;
                case 2:
                    System.out.print("Enter the index to insert at: ");
                    int insertIndex = scanner.nextInt();
                    System.out.print("Enter the value to insert: ");
                    int insertValue = scanner.nextInt();
                    linkedList.insertElement(insertIndex, insertValue);
                    break;
                case 3:
                    System.out.print("Enter the index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    linkedList.deleteElement(deleteIndex);
                    break;
                case 4:
                    linkedList.traverseList();
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
