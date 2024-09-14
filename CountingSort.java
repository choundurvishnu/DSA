package A1;

import java.util.Scanner;

public class CountingSort {

    public static void countingSort(int[] array) {
        if (array.length == 0) return;

        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];
        for (int num : array) {
            count[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                array[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        countingSort(numbers);

        System.out.println("Sorted array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}


