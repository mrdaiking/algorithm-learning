import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Description: Main.java 
* Author: Cuong 
* Date: 2024/05/05 
* Time: 13:14:41
*/
public class Main {
    public static void main(String[] args) {

        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        printArray(array);
        long startTime = System.nanoTime();
//        insertionSort(array);
        mergeSort(array, 0, array.length - 1);

        long endTime = System.nanoTime();
        long duration = endTime - startTime; // in nano
        System.out.println("\nSorted array:");
        printArray(array);
        System.out.println("\nRunning time: " + duration + " nanoseconds");

    }

    public static void mergeSort(int[] array, int left, int right) {

        if (left >= right) return;
        int mid = (left + right) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);

    }

    public static void merge(int[] array, int left, int mid, int right)  {
        int leftSize = mid - left + 1; // Length of A[left:mid]
        int rightSize = right - mid;  // Length of A[mid +1 :right]

        int[] leftArray = new int[leftSize];// Create new arrays
        int[] rightArray = new int[rightSize];

        System.arraycopy(array, left + 0, leftArray, 0, leftSize);
//        System.out.println("\nLeft array:");

//        printArray(leftArray);
        System.arraycopy(array, mid, rightArray, 0,rightSize);
//        for (int j = 0; j < leftArray.length; j++) {
//            rightArray[j] = array[mid + j + 1];
//        }
//        System.out.println("\nRight array:");
//        printArray(rightArray);

        int i = 0;
        int j = 0;
        int k = left;


        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

  public static void insertionSort(int[] inputs) {
        for (int i = 1; i < inputs.length;i++) {
            int currentValue = inputs[i];
            int previousIndex = i - 1;

            while (previousIndex >= 0 && inputs[previousIndex] > currentValue) {
                inputs[previousIndex + 1] = inputs[previousIndex];
                previousIndex--;
            }
            inputs[previousIndex+1] = currentValue;
        }
  }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}

