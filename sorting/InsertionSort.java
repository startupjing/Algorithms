/**
 * Insertion Sort:
 *   for i = 1,2, ..., n
 *      insert A[i] into sorted array A[0:i-1] by pairwise swaps
 *      down to the correct position
 *   end
 *
 * Complexity
 *   time O(n^2)
 *
 * Analysis:
 *   1. O(n) steps, and each step takes O(n) time to swap
 *   2. comparison cost vs. swap cost (normally the same)
 *
 * Improvement:
 *   Binary Insertion Sort:
 *       If comparison cost is large, we need to avoid pairwise comparison by replacing it by binary search
 *   and turn the algorithm into O(nlogn) for comparison but still O(n^2) for swaps
 *
 */

public class InsertionSort {
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

        for(int i=1; i<arr.length; i++) {
            int key = arr[i];
            int insertIdx = i - 1;

            //find index to insert key
            while(insertIdx>=0 && arr[insertIdx]>key) {
                arr[insertIdx+1] = arr[insertIdx];    //shift elements to right
                insertIdx --;
            }

            //insert key
            arr[insertIdx+1] = key;

        }
    }

}
