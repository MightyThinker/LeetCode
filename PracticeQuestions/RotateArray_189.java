/*
 * Question 189: Rotate Array
 * You are given an array nums and an integer k. You want to rotate the array to the right by k steps, where k is non-negative.

 ? Constraints:
 ?  1 <= nums.length <= pow(10,5)
 ?  -pow(2,31) <= nums[i] <= pow(2,31) - 1
 ?  0 <= k <= pow(10,5)
 * 
 */


class Solution_189 {

    // Reverse Array between indices i and j
    public void reverse(int[] nums, int i, int j) {
        while(i<=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

    }
    public void rotate(int[] nums, int k) {
        /*
         * nums = [1,2,3,4,5,6,7]
         * k=3
         * output = [5,6,7,1,2,3,4]
         * What shgould happen → [1,2,3,4][5,6,7] → [5,6,7][1,2,3,4]
         * 1st approach is to reverse the array so the last should come first → [7,6,5,4,3,2,1]
         * Now reverse k positions from beginning → [5,6,7,4,3,2,1]
         * Now reverse remaining elements → [5,6,7,1,2,3,4]
         */

        // Full reverse
        reverse(nums,0,nums.length-1);

        int rotation = k%nums.length; // If the rotation is more than length of array

        // Part reverse
        reverse(nums,0,(rotation-1));
        reverse(nums,rotation,nums.length-1);
    }
}

// Complexity
// Time Complexity: O(n)
// Space Complexity: O(1)

public class RotateArray_189 {
    public static void main(String[] args) {
        Solution_189 solution = new Solution_189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.print("Array after rotation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
