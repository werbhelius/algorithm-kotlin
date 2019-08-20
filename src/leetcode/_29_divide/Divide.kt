package leetcode._29_divide

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
class Solution {
    fun divide(dividend: Int, divisor: Int): Int {

        if (dividend == 0) return 0

        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }

        var i = Math.abs(dividend.toLong())
        val j =  Math.abs(divisor.toLong())

        val negative = (dividend xor divisor) < 0
        var ans = 0

        for (num in 31 downTo 0) {
            val value = i shr num
            if (value >= j) {
                ans += (1 shl num)
                i -= (j shl num)
            }
        }

        return if (negative) -ans else ans

    }

}

fun main() {
    Solution().divide(-2147483648, 1)
}