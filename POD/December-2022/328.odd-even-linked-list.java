/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
 *
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * algorithms
 * Medium (58.09%)
 * Likes:    3888
 * Dislikes: 355
 * Total Accepted:    433.3K
 * Total Submissions: 743.9K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered
 * list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 *
 *
 * Example 2:
 *
 *
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 *
 *
 *
 * Constraints:
 *
 *
 * n == number of nodes in the linked list
 * 0 <= n <= 10^4
 * -10^6 <= Node.val <= 10^6
 *
 *
 */

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

// @lc code=start

class Solution {

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }

  private ListNode alternateSolution(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode sentinel = new ListNode(0, head);
    ListNode odd = head;
    ListNode evenStart = head.next;
    ListNode even = head.next;
    while (even.next != null && even.next.next != null) {
      odd.next = odd.next.next;
      odd = odd.next;
      even.next = even.next.next;
      even = even.next;
    }
    if (even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = null;
    }
    odd.next = evenStart;
    return sentinel.next;
  }
}
// @lc code=end
