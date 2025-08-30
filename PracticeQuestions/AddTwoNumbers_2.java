/*
 * Question 2: Add Two Numbers
 ? You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contains a single digit. Add the two numbers and return it as a linked list.
 ? You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 ? Constraints:
 ?  The number of nodes in each linked list is in the range [1, 100].
 ?  0 <= Node.val <= 9
 ?  It is guaranteed that the list represents a number that does not have leading zeros.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /*
         * Initialize carry to 0
         * Create a dummy head for the result list
         * Create a pointer for the current node
         * Initialize the current node to the dummy head
         * Iterate while either list is not null or carry is not 0
         * For each iteration:
         *   - Initialize sum to 0
         *   - Add value of each nodes(if not null) to sum
         *   - Move temp pointer for each list to next
         *   - Calculate the sum and the new carry
         *   - Create a new node for the result list
         *   - Add val to mod 10 of sum to new node for result list and update carry to sum/10
         *   - Move the current pointer to the new node
         *   - Update the pointers for the input lists
         * Return the next node of the dummy head
         */

        int carry = 0;
        ListNode resultList = new ListNode(0);
        ListNode curr = resultList;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while(carry != 0 || temp1 != null || temp2 != null) {
            int sum = 0;
            if(temp1 != null){
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }
            if(carry != 0) {
                sum += carry;
            }
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            
        }

        return resultList.next;        
    }
}
// Complexity
// Time Complexity: O(max(m, n)), where m and n are the lengths of the two linked lists.
// Space Complexity: O(max(m, n)), for the result linked list.

public class AddTwoNumbers_2 {
    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();

        // Example 1:
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1, l2);
        printList(result); // Expected Output: 7 -> 0 -> 8

        // Example 2:
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        result = solution.addTwoNumbers(l1, l2);
        printList(result); // Expected Output: 0

        // Example 3:
        l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        l2 = new ListNode(1);
        result = solution.addTwoNumbers(l1, l2);
        printList(result); // Expected Output: 0 -> 0 -> 0 -> 1
    }
}
