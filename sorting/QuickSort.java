/**
 * QuickSort: partition around the pivot
 *
 * Time Complexity: best and average - O(nlogn)
 *        worst - O(n^2)
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] test = new int[]{5, 1, 8, 3, 4, -1, 8, 3};
        sort(test, 0, test.length-1);
        for(int n: test) {
            System.out.print(n + " ");
        }
    }

    public static void sort(int[] nums, int low, int high) {
        if(low < high) {
            int pivotIdx = partition(nums, low, high);
            sort(nums, low, pivotIdx-1);
            sort(nums, pivotIdx+1, high);
        }
    }

    /**
     * always use highest index as pivotIndex
     */
    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int storeIdx = low;

        for(int i=low; i<high; i++) {
            if(nums[i] <= pivot) {
                swap(nums, storeIdx, i);
                storeIdx ++;
            }
        }
        swap(nums, storeIdx, high);
        return storeIdx;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
