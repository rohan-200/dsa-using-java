public class MaxMinDivideAndConquer {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = findMaxMin(arr, 0, arr.length-1);
        System.out.println("Max: " + result[0]);
        System.out.println("Min: " + result[1]);
    }

    public static int[] findMaxMin(int[] arr, int low, int high) {
        int[] result = new int[2];
        if (low == high) {
            result[0] = arr[low];  // max
            result[1] = arr[low];  // min
            return result;
        } else if (high - low == 1) {
            result[0] = Math.max(arr[low], arr[high]);  // max
            result[1] = Math.min(arr[low], arr[high]);  // min
            return result;
        } else {
            int mid = (low + high) / 2;
            int[] leftResult = findMaxMin(arr, low, mid);
            int[] rightResult = findMaxMin(arr, mid+1, high);
            result[0] = Math.max(leftResult[0], rightResult[0]);  // max
            result[1] = Math.min(leftResult[1], rightResult[1]);  // min
            return result;
        }
    }

}
