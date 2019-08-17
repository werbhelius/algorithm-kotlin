package leetcode._19_removeNthFromEnd

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
class Solution {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null

    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast = head
        var slow = head

        repeat(n) {
            fast = fast?.next
            if (fast == null) {
                return head?.next
            }
        }

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next
        }

        val temp = slow?.next
        slow?.next = temp?.next

        return head

    }
}