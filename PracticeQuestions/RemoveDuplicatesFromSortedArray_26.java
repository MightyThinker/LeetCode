/*
 * Question 26: Remove Duplicates from Sorted Array
 ? You are given a sorted array nums. You want to remove the duplicates in-place such that each element appears only once and returns the new length of the array.
 ? Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 ? Constraints:
 ?  1 <= nums.length <= 3 * pow(10, 4)
 ?  -100 <= nums[i] <= 100
 ?  nums is sorted in non-decreasing order.
 */


class Solution_26 {
    public int removeDuplicates(int[] nums) {

        /*
         * keep a slow pointer for the last unique element and sweep a fast pointer through the array;
         * when a new value is different from the last unique, write it next and advance the slow pointer.
         * The returned size is the count of unique elements, which equals slow+1.
         * 
         * Handle n == 0: return 0. Initialize k = 1 (first element is always unique).
         * For i from 1 to n-1:
         *   if nums[i] != nums[k-1], then write nums[i] to nums[k] and increment k.
         * Return k. Elements beyond k are ignored.
         */

        if (nums.length == 0) return 0;

        int k = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[k-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

// Complexity
// Time: O(n), where n is the length of the array
// Space: O(1), no extra space used

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        Solution_26 solution = new Solution_26();
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = solution.removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
