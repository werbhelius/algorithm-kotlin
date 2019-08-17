package leetcode._21_mergeTwoLists

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
class Solution {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null

    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 == null) return l2
        if (l2 == null) return l1

        if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            return l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            return l2
        }

    }
}

fun main() {

    val node1 = Solution.ListNode(1).apply {
        next = Solution.ListNode(2).apply {
            next = Solution.ListNode(4)
        }
    }

    val node2 = Solution.ListNode(1).apply {
        next = Solution.ListNode(3).apply {
            next = Solution.ListNode(4)
        }
    }

    Solution().mergeTwoLists(node1, node2)
}