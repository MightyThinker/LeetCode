/*
 * Question 26: Remove Duplicates from Sorted Array
 * You are given a sorted array nums. You want to remove the duplicates in-place such that each element appears only once and returns the new length of the array.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */


class Solution_26 {
    public int removeDuplicates(int[] nums) {
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
