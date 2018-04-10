package no002.add.two.numbers;

public class Solution {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode temp = null;
    ListNode result = null;
    boolean upCount = false;
    while (l1 != null || l2 != null) {
      int sum;

      if (l1 == null) {
        sum = l2.val;
        l2 = l2.next;
      } else if (l2 == null) {
        sum = l1.val;
        l1 = l1.next;
      } else {
        sum = l1.val + l2.val;
        l1 = l1.next;
        l2 = l2.next;
      }

      if (upCount == true) {
        sum++;
      }

      if (sum > 9) {
        upCount = true;
        sum -= 10;
      } else {
        upCount = false;
      }
      if (temp == null) {
        result = new ListNode(sum);
        temp = result;
      } else {
        temp.next = new ListNode(sum);
        temp = temp.next;
      }

    }

    if (upCount == true) {
      temp.next = new ListNode(1);
    }

    return result;
  }
}
