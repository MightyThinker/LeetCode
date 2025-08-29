/* 
 * Question 1752: Check if Array is Sorted and Rotated

 ? You have been given an array `nums` such that it is sorted initially in ascending order and from some point it has been rotated.
 ? You have to check if it has been really rotated or not and return `true` in case of rotated else `false`.
 ? There may be duplicate values in the arrays.
 ? Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.

 ? Constraints:
 ?  1 <= nums.length <= 100
 ?  1 <= nums[i] <= 100
 */

class Solution_1752 {
    // Function to check if the array is sorted and rotated 
    public boolean check(int[] nums) {
        /*
         * For a non-decreasing array rotated some times, there can be at most one "drops" i.e., drops <=1 when scanning the array circularly.
         * A "drop" is defined as a point where the current element is greater than the next element.
         * If we find more than one drop, we can immediately return false.
         * 
         * Example A: → comparisons: 3≤4, 4≤5, 5>1 (drop #1), 1≤2, 2≤3 (via wrap). Exactly one drop → true.
         * Example B: → 2>1 (drop #1), 1≤3, 3≤4, and 4>2 (wrap drop #2) → two drops → false.
         */

        int drops = 0;
        int size = nums.length;

        for(int i=0;i<size;i++) {
            if(nums[i]>nums[(i+1)%size]) {
                drops++;
            }
        }
        
        return drops <= 1;
    }
}

// Complexity
// Time: O(n), where n is the length of the array
// Space: O(1), no extra space used

public class CheckIfArrayIsSortedAndRotated_1752 {
    public static void main(String[] args) {
        Solution_1752 solution = new Solution_1752();
        System.out.println(solution.check(new int[]{3, 4, 5, 1, 2})); // true
        System.out.println(solution.check(new int[]{2, 1, 3, 4})); // false
    }
}


