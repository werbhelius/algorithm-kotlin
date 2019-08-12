package leetcode._7_reverse

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
class Solution {
    fun reverse(x: Int): Int {

        var num = x
        var ans = 0

        while (num != 0) {
            val _ans =  ans * 10 + num % 10
            if (_ans / 10 != ans) {
                return 0
            }
            ans = _ans
            num /= 10
        }

        return ans
    }
}

fun main() {
    Solution().reverse(120)
}