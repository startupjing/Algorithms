/**
 * Binary Search: search element in a sorted array
 *
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] test = new int[]{2,3,4,10,20};
        System.out.println(iterative_search(test, 4));
        System.out.println(recursive_search(test, 20));
    }

    /**
     * iterative approach
     * time O(logn)
     * space O(1)
     */
    public static int iterative_search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(target < nums[mid]) {
                high = mid - 1;
            }else if(nums[mid] < target) {
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * recursive approach
     * time O(logn)
     * space O(logn) stack space
     */
    public static int recursive_search(int[] nums, int target) {
        return search_helper(nums, target, 0, nums.length-1);
    }

    public static int search_helper(int[] nums, int target, int low, int high) {
        if(low <= high) {
            int mid = low + (high - low)/2;
            if(target < nums[mid]) {
                return search_helper(nums, target, low, mid - 1);
            }else if(nums[mid] < target) {
                return search_helper(nums, target, mid+1, high);
            }else {
                return mid;
            }
        }else {
            return - 1;
        }
    }
}