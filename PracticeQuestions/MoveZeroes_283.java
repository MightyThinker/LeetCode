/*
 * Question 283: Move Zeroes
 * 
 ? Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 ? You must do this in-place without making a copy of the array.

 ? Constraints:
 ?  1 <= nums.length <= pow(10,4)
 ?  -pow(10,9) <= nums[i] <= pow(10,9)
 */

class Solution_283 {
    public void moveZeroes(int[] nums) {

        /*
         * Two-pointer approach
         * - One pointer (k) keeps track of the position to place the next non-zero element.
         * - The other pointer (i) iterates through the array.
         * For each non-zero element found by pointer i, swap it with the element at pointer k and increment k.
         */

        int k = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0 && nums[k]==0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
            if(nums[k] != 0) {
                k++;
            }
        }        
    }
}
// Complexity:
// Time: O(n)
// Space: O(1)

public class MoveZeroes_283 {
    public static void main(String[] args) {
        Solution_283 solution = new Solution_283();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
