package leetcode._24_swapPairs

class Solution {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null

    }

    fun swapPairs(head: ListNode?): ListNode? {

        if (head?.next == null) {
            return head
        }

        val next = head.next
        head.next = swapPairs(next?.next)
        next?.next = head
        return next

    }

    fun swapPairs2(head: ListNode?): ListNode? {

        if (head?.next == null) {
            return head
        }

        val dummyhead: ListNode? = ListNode(0).apply {
            next = head
        }

        var temp = dummyhead

        while (temp?.next != null && temp.next?.next != null) {
            val start = temp.next
            val end = temp.next?.next

            temp.next = end
            start?.next = end?.next
            end?.next = start
            temp = start

        }




        return dummyhead?.next


    }

}

fun main() {
    val node = Solution.ListNode(1).apply {
        next = Solution.ListNode(2).apply {
            next = Solution.ListNode(3).apply {
                next = Solution.ListNode(4)
            }
        }
    }

    Solution().swapPairs(node)
}