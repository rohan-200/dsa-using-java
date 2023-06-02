package assignment_V;

import java.util.Arrays;

public class SortingTechniques {
    
    public static void main(String[] args) {
        int[] arr = {9, 2, 5, 1, 8, 3, 7, 4, 6};
        int[] arr2 = {9, 2, 5, 1, 8, 3, 7, 4, 6};
        int[] arr3 = {9, 2, 5, 1, 8, 3, 7, 4, 6};
        int[] arr4 = {9, 2, 5, 1, 8, 3, 7, 4, 6};
        int[] arr5 = {9, 2, 5, 1, 8, 3, 7, 4, 6};
        int[] arr6 = {9, 2, 5, 1, 8, 3, 7, 4, 6};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        selectionSort(arr);
        System.out.println("Selection Sort: " + Arrays.toString(arr));
        
        insertionSort(arr2);
        System.out.println("Insertion Sort: " + Arrays.toString(arr2));
        
        quickSort(arr3, 0, arr.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(arr3));
        
        mergeSort(arr4, 0, arr.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(arr4));
        
        radixSort(arr5);
        System.out.println("Radix Sort: " + Arrays.toString(arr5));
        
        heapSort(arr6);
        System.out.println("Heap Sort: " + Arrays.toString(arr6));
    }
    
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
    
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
            System.out.println(Arrays.toString(arr));
        }
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        System.out.println(Arrays.toString(arr));
        return i + 1;
    }
    
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int m = 0; m < temp.length; m++) {
            arr[low + m] = temp[m];
        }
        System.out.println(Arrays.toString(arr));
    }
    
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }
    
    public static void countSort(int[] arr, int exp) {
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
            System.out.println(Arrays.toString(arr));
        }
    }
    
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}