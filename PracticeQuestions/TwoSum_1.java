/*
 * Question 1: Two Sum
 * 
 ? Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 ? You may assume that each input would have exactly one solution, and you may not use the same element twice.
 ? You can return the answer in any order.
 */

import java.util.HashMap;
import java.util.Map;

class Solution_1 {
    public int[] twoSum(int[] nums, int target) {

        /*
         * Create a result array to store the indices of the two numbers, and initialize it with -1 values.
         * Create a HashMap to store the numbers and their indices.
         * Check if the complement (target - nums[i]) exists in the HashMap.
         * If it exists, update the result array with the indices, and break out of loop.
         * Otherwise, add the current number and its index to the HashMap.
         * Now after coming out of loop we have indices(if exists) in result and return the result.
         */

        int[] result = new int[] {-1,-1};

        Map<Integer,Integer> myMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(myMap.containsKey(target - nums[i])){
                result[0] = myMap.get(target - nums[i]);
                result[1] = i;
                break;
            }
            myMap.put(nums[i], i);
        }

        return result;
    }
}

// Complexity:
// Time Complexity: O(n), where n is the number of elements in the array.
// Space Complexity: O(n), for the HashMap to store the elements and their indices.

public class TwoSum_1 {
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices of the two numbers are: " + result[0] + " and " + result[1]);
    }
}