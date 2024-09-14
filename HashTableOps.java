package A1;
import java.util.Hashtable;
import java.util.Scanner;

public class HashTableOps {


    public static void main(String[] args) {
       
        Hashtable<String, String> hashtable = new Hashtable<>();
        
       
        Scanner scanner = new Scanner(System.in);

    
        while (true) {
            System.out.println("Hashtable Operations:");
            System.out.println("1. Insert (Add a key-value pair)");
            System.out.println("2. Delete (Remove a key-value pair)");
            System.out.println("3. Search (Find a value by key)");
            System.out.println("4. Update (Change a value by key)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                   
                    System.out.print("Enter key: ");
                    String insertKey = scanner.nextLine();
                    System.out.print("Enter value: ");
                    String insertValue = scanner.nextLine();
                    hashtable.put(insertKey, insertValue);
                    System.out.println("Inserted: " + insertKey + " -> " + insertValue);
                    break;

                case 2:
                    
                    System.out.print("Enter key to delete: ");
                    String deleteKey = scanner.nextLine();
                    if (hashtable.remove(deleteKey) != null) {
                        System.out.println("Removed: " + deleteKey);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 3:
                    
                    System.out.print("Enter key to search: ");
                    String searchKey = scanner.nextLine();
                    String value = hashtable.get(searchKey);
                    if (value != null) {
                        System.out.println("Value for " + searchKey + " is " + value);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 4:
                    
                    System.out.print("Enter key to update: ");
                    String updateKey = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String updateValue = scanner.nextLine();
                    if (hashtable.containsKey(updateKey)) {
                        hashtable.put(updateKey, updateValue);
                        System.out.println("Updated: " + updateKey + " -> " + updateValue);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 5:
                   
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
