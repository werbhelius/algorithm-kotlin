package leetcode._13_romanToInt


/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
class Solution {
    fun romanToInt(s: String): Int {

        if (s.isEmpty() || s == " ") return 0

        var ans = 0
        var last = ' '
        val map = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)


        for (i in s.length - 1 downTo 0) {
            val char = s[i]

            if (last != ' ' && (map[char] ?: 0) < (map[last] ?: 0)) {
                ans -= (map[char] ?: 0)
            } else {
                ans += map[char] ?: 0
            }

            last = char
        }

        return ans

    }
}

fun main() {
    Solution().romanToInt("III")
}