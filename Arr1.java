package A1;
import java.util.*;
import java.util.Scanner;


public class Arr1 {
	
	static int[] arr;
	static int n ;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
			
		while (true) {
            System.out.println("Array Operations Menu:");
            System.out.println("1. Create Array");
            System.out.println("2. Insert Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Traverse Array");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            
            switch(choice) {
            
            case 1:
            	arr = creation(sc);
            	break;
            case 2:
            	arr = insertion(arr,sc);
            	break;
            case 3:
            	arr = deletion(arr,sc);
            	break;
            case 4:
            	traverse();
            	break;
            case 5:
            	System.out.println("Exiting...");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                break;
                      
            }
   
		}

	}
	
	
	public static int[] creation(Scanner sc) {
		System.out.println("Enter the Size of the array : ");
		n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Array created with size "+n);
		return arr;
		
	}
	
	public static int[] insertion(int[] array, Scanner sc) {
		
	
		
		System.out.print("Enter index to insert (0 to " + (n - 1) + "): ");
        int index = sc.nextInt();
        if (index < 0 || index >= n) {
            System.out.println("Invalid index.");
            return array;
        }
        System.out.print("Enter the value to insert: ");
        int value = sc.nextInt();
        int[] arr = new int[array.length + 1];
        for (int i = 0; i < index; i++) {
            arr[i] = array[i];
        }
        arr[index] = value;
        for (int i = index; i < array.length; i++) {
            arr[i + 1] = array[i];
        }
        return arr;
        
	}
	
	public static int[] deletion(int[] array,Scanner sc)
	{
		
        System.out.print("Enter index to delete (0 to " + (n - 1) + "): ");
        int index = sc.nextInt();
        if (index < 0 || index >= n) {
            System.out.println("Invalid index.");
            return array;
        }
        System.out.println("Deleted element is "+array[index]+ " with position is "+index);
    
        int[] arr = new int[array.length - 1];
        for (int i = 0; i < index; i++) {
            arr[i] = array[i];
        }
        for (int i = index; i < arr.length; i++) {
            arr[i] = array[i + 1];
        }
        return arr;
	
	
	}
	
	
	public static void traverse() {
		if(n ==0)
		{
			System.out.println("Array is not created. Please create an array first.");
            return;
		}
		System.out.println("Array contents:");
        for (int i = 0; i < n; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }
	}
	


}
