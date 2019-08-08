package leetcode._2_addTwoNumbers

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var copyL1 = l1
        var copyL2 = l2
        var moveNode = dummyHead
        var carry = 0

        while (copyL1 != null || copyL2 != null || carry > 0) {
            val p = copyL1?.`val` ?: 0
            val q = copyL2?.`val` ?: 0
            var l3 = p + q + carry
            carry = 0

            if (l3 > 9) {
                carry = 1
                l3 -= 10
            }

            moveNode.next = ListNode(l3)

            moveNode = moveNode.next!!
            copyL1 = copyL1?.next
            copyL2 = copyL2?.next

        }

        return dummyHead.next
    }

    fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
        return add(l1, l2, null)
    }

    private fun add(l1: ListNode?, l2: ListNode?, pre: ListNode?): ListNode? {
        val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
        val newNode = ListNode(sum)
        pre?.also {
            if (it.`val` >= 10) {
                it.`val` = it.`val` % 10
                newNode.`val` += 1
            }
        }

        if (l1?.next != null || l2?.next != null ){
            newNode.next = add(l1?.next, l2?.next, newNode)
        } else if (newNode.`val` >= 10) {
            newNode.next = add(l1?.next, l2?.next, newNode)
        }


        return newNode

    }

}

fun main() {
    val l1 = Solution.ListNode(9).apply {
        //        next = Solution.ListNode(2).apply {
//            next = Solution.ListNode(3)
//        }
    }

    val l2 = Solution.ListNode(1).apply {
        next = Solution.ListNode(9).apply {
            next = Solution.ListNode(9).apply {
                next = Solution.ListNode(9).apply {
                    next = Solution.ListNode(9).apply {
                        next = Solution.ListNode(9).apply {
                            next = Solution.ListNode(9).apply {
                                next = Solution.ListNode(9).apply {
                                    next = Solution.ListNode(9).apply {
                                        next = Solution.ListNode(9)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    Solution().addTwoNumbers(l1, l2)
}