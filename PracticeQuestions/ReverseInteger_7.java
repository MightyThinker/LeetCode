/*
 * Question 7: Reverse Integer
 * 
 ? Given a signed 32-bit integer x, return x with its digits reversed.
 ? If reversing x causes the value to go outside the signed 32-bit integer range [-2147483648, 2147483647], then return 0.

 ? Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */


class Solution_7 {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int digit = x%10;
            x /= 10;

            if(rev > 214748364 || (rev == 214748364 && digit > 7) || rev < -214748364 || (rev == -214748364 && digit < -8)) return 0;

            rev = rev * 10 + digit;
        }

        return rev;
    }
}
// Complexity:
// Time: O(log10(n)), where n is the input number
// Space: O(1)

public class ReverseInteger_7 {
    public static void main(String[] args) {
        Solution_7 solution = new Solution_7();
        System.out.println(solution.reverse(123));  // Output: 321
        System.out.println(solution.reverse(-123)); // Output: -321
        System.out.println(solution.reverse(120));  // Output: 21
        System.out.println(solution.reverse(0));    // Output: 0
    }

}
