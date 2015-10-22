/**
 * search.QuickSelect: select n-th smallest element from unsorted array
 *
 * Time complexity:
 *    best and average - O(n)
 *    worst - O(n^2)
 */

public class QuickSelect {
    public static void main(String[] args) {
        int[] test = new int[]{99, 99};
        System.out.println(quickSelect(test, 0, test.length-1, 1));
    }

    /**
     * select n-th smallest element (n=0,1,2,...)
     */
    public static int quickSelect(int[] nums, int low, int high, int n) {
        if(low == high) {
            return nums[low];
        }

        int pivotIdx = high;
        pivotIdx =partition(nums, low, high, pivotIdx);

        //pivot is at the final destination, and it should be nth smallest element
        if(pivotIdx == n) {
            return nums[n];
        }else if(pivotIdx < n) {
            return quickSelect(nums, pivotIdx+1, high, n);
        }else {
            return quickSelect(nums, low, pivotIdx-1, n);
        }
    }

    /**
     * partition using the given index
     */
    public static int partition(int[] nums, int low, int high, int pivotIdx) {
        int pivot = nums[pivotIdx];
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
