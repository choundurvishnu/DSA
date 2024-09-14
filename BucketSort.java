package A1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BucketSort {

    public static void bucketSort(int[] array) {
        if (array.length <= 1) return;

        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int bucketCount = max - min + 1;
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : array) {
            buckets[num - min].add(num);
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                array[index++] = num;
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

        bucketSort(numbers);

        System.out.println("Sorted array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
