package leetcode._12_intToRoman

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
class Solution {

    /**
     * 贪心算法
     */
    fun intToRoman(num: Int): String {
        if (num == 0) return ""

        val values = intArrayOf(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)
        val strs = arrayOf("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")

        val str = StringBuilder()
        var numCpoy = num

        for (i in values.size - 1 downTo 0) {
            while (numCpoy >= values[i]) {
                str.append(strs[i])
                numCpoy -= values[i]
            }

        }

        return str.toString()
    }
}

fun main() {
    Solution().intToRoman(111)
}