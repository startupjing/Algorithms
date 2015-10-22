package algorithm.sorting;

/**
 * Merge Sort (Divide and Conquer)
 *
 *
 * Complexity:
 *   time O(nlogn)
 *   space O(n)
 *
 * Analysis:
 *  1. Recurrence: T(n) = c1 + 2T(n/2) + c2 * n = divide + subproblems + merge
 *  2. Shortness: use O(n) extra space
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] test = new int[]{5, 1, 8, 3, 4, -1, 8, 3};
        sort(test);
        for(int n: test) {
            System.out.print(n + " ");
        }
    }

    public static void sort(int[] arr) {
        if(arr==null || arr.length<=1) {
            return;
        }
        sortInRange(arr, 0, arr.length-1);

    }

    public static void sortInRange(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left)/2;
            sortInRange(arr, left, mid);
            sortInRange(arr, mid+1, right);
            mergeSortedArray(arr, left, mid, right);
        }
    }

    public static void mergeSortedArray(int[] arr, int left, int mid, int right) {
        //extra space to store two sorted arrays
        int[] arr1 = new int[(mid-left+1)+1];
        int[] arr2 = new int[(right-mid)+1];

        //fill in two arrays with sorted array
        for(int i=0; i<arr1.length-1; i++) {
            arr1[i] = arr[left + i];
        }

        for(int i=0; i<arr2.length-1; i++) {
            arr2[i] = arr[mid+1+i];
        }

        //put MAX_VALUE as flag to stop exploring the array
        arr1[arr1.length-1] = Integer.MAX_VALUE;
        arr2[arr2.length-1] = Integer.MAX_VALUE;

        //merge two sorted array using two pointers
        int iter1 = 0;
        int iter2 = 0;
        for(int i=left; i<=right; i++) {
            if(arr1[iter1] < arr2[iter2]) {
                arr[i] = arr1[iter1];
                iter1 ++;
            }else {
                arr[i] = arr2[iter2];
                iter2 ++;
            }
        }
    }
}
